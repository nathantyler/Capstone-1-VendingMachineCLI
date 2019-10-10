package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Item {



	public Chips(String name, BigDecimal price) {
		super(name, price);
		type = "Chip";
		message = "Crunch Crunch, Yum!";
	}

}
