package com.challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.challenge.messenger.ReceiverProcess;
import com.challenge.messenger.Sender;
import com.challenge.model.Chat;
import com.challenge.model.Profile;
import com.challenge.services.ChatServices;
import com.challenge.services.ProcessMessageService;
import com.challenge.services.ProfileServices;

@SpringBootApplication
@EnableMongoAuditing
public class ChallengeApplication implements CommandLineRunner {
	
	@Autowired
	private ProfileServices profileServices;
	
	@Autowired
	private ChatServices chatServices;
	
	@Autowired
	private ProcessMessageService ProcessMessageService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		profileServices.deleteAll();
		chatServices.deleteAll();
		
//		Persisting 3 Profiles
		List<Profile> listProfile = new ArrayList<>();
		listProfile.add(new Profile("Daniel"));
		listProfile.add(new Profile("Alejandro"));
		listProfile.add(new Profile("Arcos"));
		profileServices.save(listProfile);
		
		System.out.println("----------------------------------- PROFILES -----------------------------------");
		for (Profile profile : profileServices.findAll()) {
			System.out.println(profile);
		}
		
//		Persisting a 60 line chat for Daniel
		for (int i = 0; i < 60; i++) {
			chatServices.save(new Chat("Daniel", "Message " + i));
		}
		
		System.out.println("----------------------------------- CHAT -----------------------------------");
		for (Chat chat : chatServices.findAll(new PageRequest(0, 50, new Sort(Direction.DESC, "date")))) {
			System.out.println(chat);
		}
		
//		***************************************************************************
		
		System.out.println("Sending stock message...");
        
        ProcessMessageService.manageMessage(profileServices.findOne("Alejandro"), "/stock=AAPL​");
        ProcessMessageService.manageMessage(profileServices.findOne("Alejandro"), "/day_range=AAPL​");
        		
	}
}
