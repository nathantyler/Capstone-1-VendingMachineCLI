package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {

	public Drink(String position, String name, BigDecimal price) {
		super(position, name, price);
		type = "Drink";
		message = "Glug Glug, Yum!";
		stock = 5;
	}
	
	public Drink() {
		type = "Drink";
		message = "Glug Glug, Yum!";
		stock = 5;
	}

}
