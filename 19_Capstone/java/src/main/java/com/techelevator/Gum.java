package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {

	public Gum(String position, String name, BigDecimal price) {
		super(position, name, price);
		type = "Gum";
		message = "Chew Chew, Yum!";
		stock = 5;
	}
	
	public Gum() {
		type = "Gum";
		message = "Chew Chew, Yum!";
		stock = 5;
	}

}
