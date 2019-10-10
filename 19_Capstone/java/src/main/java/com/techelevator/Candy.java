package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String name, BigDecimal price) {
		super(name, price);
		type = "Candy";
		message = "Munch Munch, Yum!";
	}

}
