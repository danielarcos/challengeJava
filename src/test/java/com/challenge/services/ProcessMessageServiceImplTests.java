package com.challenge.services;


import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.messenger.Sender;
import com.challenge.model.Chat;
import com.challenge.model.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessMessageServiceImplTests {
	
	@Mock
	private Sender sender;
	
	@Mock
	private ChatServices chatServices;
	
	@InjectMocks
	@Resource
	private ProcessMessageServiceImpl processMessageServiceImpl;
	
	@Test
	public void manageMessageCallingTest() {
		
		Profile profile = new Profile("ProfTest");
		String test = "Test String";
		
		processMessageServiceImpl.manageMessage(profile, test);
		
		Mockito.verify(chatServices, Mockito.atLeastOnce()).save(Mockito.any(Chat.class));
		
	}
	
	@Test
	public void manageMessageCallingSenderWhenStockTest() {
		
		Profile profile = new Profile("ProfTest");
		String test = "/stock=AAPL​";
		
		processMessageServiceImpl.manageMessage(profile, test);
		
		Mockito.verify(sender, Mockito.atLeastOnce()).sendMessage(test);
		
	}
	
	@Test
	public void manageMessageCallingSenderWhenDaysRangeTest() {
		
		Profile profile = new Profile("ProfTest");
		String test = "/day_range=AAPL​";
		
		processMessageServiceImpl.manageMessage(profile, test);
		
		Mockito.verify(sender, Mockito.atLeastOnce()).sendMessage(test);
		
	}

}
