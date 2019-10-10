package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {

	public Gum(String name, BigDecimal price) {
		super(name, price);
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
