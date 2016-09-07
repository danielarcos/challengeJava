package com.challenge.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

public class Chat {

	@Id
	private String id;
	
	private String userName;
	private String message;
	@CreatedDate
	private Date date;
	
	public Chat(String userName, String message) {
		super();
		this.userName = userName;
		this.message = message;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Message from '%s' ('%s')\n '%s'",
                userName, date, message);
    }
}
