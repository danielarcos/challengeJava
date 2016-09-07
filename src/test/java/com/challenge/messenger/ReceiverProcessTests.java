package com.challenge.messenger;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.model.Chat;
import com.challenge.services.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiverProcessTests {
	
	@Mock
	private  ChatServices chatServices;
	
	@InjectMocks
	@Resource
	private ReceiverProcess receiverProcess;
	
	@Test
	public void receiverProcessCallingBadStockTest() {
		
		String test = "/stock=APPL​";
		receiverProcess.receiveMessage(test);
		
		Mockito.verify(chatServices, Mockito.atLeastOnce()).save(Mockito.any(Chat.class));
		
	}
	
	@Test
	public void receiverProcessCallingStockTest() {
		
		String test = "/stock=AAPL​";
		receiverProcess.receiveMessage(test);
		
		Mockito.verify(chatServices, Mockito.atLeastOnce()).save(Mockito.any(Chat.class));
		
	}
	
	@Test
	public void receiverProcessCallingDayRangeTest() {
		
		String test = "/day_range=AAPL​";
		receiverProcess.receiveMessage(test);
		
		Mockito.verify(chatServices, Mockito.atLeastOnce()).save(Mockito.any(Chat.class));
	}
	
	@Test
	public void receiverProcessCallingBadDayRangeTest() {
		
		String test = "/day_range=APPL​";
		receiverProcess.receiveMessage(test);
		
		Mockito.verify(chatServices, Mockito.atLeastOnce()).save(Mockito.any(Chat.class));
	}

}
