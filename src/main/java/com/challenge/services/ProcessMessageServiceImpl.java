package com.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.constants.Commands;
import com.challenge.messenger.Sender;
import com.challenge.model.Chat;
import com.challenge.model.Profile;

@Service("processMessageServiceImpl")
public class ProcessMessageServiceImpl implements ProcessMessageService {

	@Autowired
	private Sender sender;
	
	@Autowired
	private ChatServices chatService;
	
	@Override
	public void manageMessage(Profile profile, String message) {
		
		if(message.contains(Commands.STOCK.getCommand()) || message.contains(Commands.DAY_RANGE.getCommand())){
			sender.sendMessage(message);
		} else {
			chatService.save(new Chat(profile.getUsername(), message));
		}
	}

}
