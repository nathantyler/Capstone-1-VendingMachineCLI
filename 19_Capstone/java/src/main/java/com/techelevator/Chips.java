package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Item {
	
	protected static String type, message;

	public Chips(String position, String name, BigDecimal price) {
		super(position, name, price);
		type = "Chip";
		message = "Crunch Crunch, Yum!";
		//stock = 5;
	}
	
	public Chips() {
		stock = 5;
		type = "Chip";
		message = "Crunch Crunch, Yum!";
	}
	
	public String getType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}

}
