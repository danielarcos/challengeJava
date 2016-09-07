package com.challenge.constants;

public enum Commands {
	STOCK ("/stock="),
	DAY_RANGE ("/day_range=");
	
	private final String command;
	
	Commands (String command){
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
	
	
}
