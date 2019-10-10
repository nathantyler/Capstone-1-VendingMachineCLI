package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {

	public Drink(String name, BigDecimal price) {
		super(name, price);
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
