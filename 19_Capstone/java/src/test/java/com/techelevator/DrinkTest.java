package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class DrinkTest {
	Drink drinkTest = new Drink("D5", "Pepsi", BigDecimal.valueOf(1));
	
	@Test
	public void gettersShouldReturnRelevantValues() {
		assertEquals("D5", drinkTest.getPosition());
		assertEquals("Pepsi", drinkTest.getName());
		assertEquals(BigDecimal.valueOf(1), drinkTest.getPrice());
		assertEquals("Drink", drinkTest.getType());
		assertEquals(5, drinkTest.getStock());
		assertEquals("Glug Glug, Yum!", drinkTest.getMessage());
	}

	@Test
	public void settersShouldReturnRelevantValues() {
		drinkTest.setName("New Pepsi");
		drinkTest.setStock(3);
		drinkTest.setPrice(BigDecimal.valueOf(3.0));
		drinkTest.setPosition("D1");
		
		assertEquals("New Pepsi", drinkTest.getName());
		assertEquals(3, drinkTest.getStock());
		assertEquals(BigDecimal.valueOf(3.0), drinkTest.getPrice());
		assertEquals("D1", drinkTest.getPosition());
	}
	
	@Test
	public void decrementStockShouldChangeStockValue() {
		drinkTest.decrementStock();
		drinkTest.decrementStock();
		assertEquals(3, drinkTest.getStock());
	}
}
