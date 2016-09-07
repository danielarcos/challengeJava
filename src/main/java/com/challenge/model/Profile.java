package com.challenge.model;

import org.springframework.data.annotation.Id;

public class Profile {
	@Id
	private String userName;
	
	public Profile(String userName) {
		super();
		this.userName = userName;
	}
	
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Profile [uerName='%s']",
                userName);
    }
	
	
}
