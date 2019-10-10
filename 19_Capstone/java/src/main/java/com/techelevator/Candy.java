package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String name, BigDecimal price) {
		super(name, price);
		type = "Candy";
		message = "Munch Munch, Yum!";
		stock = 5;
	}

	public Candy() {
		type = "Candy";
		message = "Munch Munch, Yum!";
		stock = 5;
	}

}
