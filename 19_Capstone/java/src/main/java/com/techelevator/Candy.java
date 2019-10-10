package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String position, String name, BigDecimal price) {
		super(position, name, price);
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
