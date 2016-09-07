package com.challenge.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.model.Profile;

public interface ProfileServices extends MongoRepository<Profile, String> {

}
