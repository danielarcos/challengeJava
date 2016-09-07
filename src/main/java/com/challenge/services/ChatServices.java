package com.challenge.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.model.Chat;

public interface ChatServices extends MongoRepository<Chat, String>{

}
