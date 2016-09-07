package com.challenge.messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.constants.Commands;
import com.challenge.constants.Urls;
import com.challenge.finance.Field;
import com.challenge.finance.List;
import com.challenge.finance.Query;
import com.challenge.model.Chat;
import com.challenge.services.ChatServices;

public class ReceiverProcess {
	
	final static String chatBot = "ChatBot";
	
	@Autowired
	ChatServices chatServices;
	
	public void receiveMessage(String message) {
		System.setProperty("http.agent", "Mozilla/5.0 (Linux; Android 6.0.1; MotoG3 Build/MPI24.107-55) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.81 Mobile Safari/537.36");
		try {
			if(message.contains(Commands.STOCK.getCommand())){
				processStock(message);
			} else {
				processDayRange(message);
			}
			
		} catch (IOException | JAXBException e) {
			chatServices.save(new Chat(chatBot, "Invalid Finance Connection"));
			e.printStackTrace();
		}
		
    }

	private void processStock(String message) throws IOException, JAXBException {
		String symbol = message.replace(Commands.STOCK.getCommand(), "").trim();
		symbol = symbol.replaceAll("[^a-zA-Z]", "").replaceAll("\\s+","");
		String url = Urls.STOCK_URL.getCommand().replace(Urls.REPLACE.getCommand(), symbol.trim());
		URL yahoo = new URL(url);
		URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        
        while ((inputLine = in.readLine()) != null){
        	stringBuilder.append(inputLine);
        }
        	
        in.close();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(List.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(stringBuilder.toString());
        List list = (List)jaxbUnmarshaller.unmarshal(reader);

        if(list.getResources().getResource() == null){
        	chatServices.save(new Chat(chatBot, "Invalid Symbol"));
        } else {
        	String price = "";
	        String name = "";
        	for (Field field: list.getResources().getResource().getField()) {
	        	if(field.getName().equals("price")){
	        		price = field.getContent();
	        	}
	        	if(field.getName().equals("name")){
	        		name = field.getContent();
	        	}
			}
        	
        	System.out.println("Saving STOCK message...");
			chatServices.save(new Chat(chatBot, String.format("%s (%s) quote is $ %s per share", symbol, name, price)));
        }
		
	}
	
	private void processDayRange(String message) throws IOException, JAXBException {
		String symbol = message.replace(Commands.DAY_RANGE.getCommand(), "").trim();
		symbol = symbol.replaceAll("[^a-zA-Z]", "").replaceAll("\\s+","");
		URL yahoo = new URL(Urls.DAY_RANGE_URL.getCommand().replace(Urls.REPLACE.getCommand(), symbol));
		URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        
        while ((inputLine = in.readLine()) != null){
        	stringBuilder.append(inputLine);
        }
        	
        in.close();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(stringBuilder.toString());
        Query query = (Query)jaxbUnmarshaller.unmarshal(reader);
        
        String daysLow = query.getResults().getQuote().getDaysLow();
        String daysHigh = query.getResults().getQuote().getDaysHigh();
        String name = query.getResults().getQuote().getName();
        
        System.out.println("Saving DAYS RANGE message...");
        chatServices.save(new Chat(chatBot, String.format("%s (%s) Days low quote is $ %s and Days high quote is $ %s", symbol, name, daysLow, daysHigh)));
	}

}
