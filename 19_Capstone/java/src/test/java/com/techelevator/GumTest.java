package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class GumTest {
	Gum gumTest = new Gum("E2", "Doublemint", BigDecimal.valueOf(6));
	
	@Test
	public void gettersShouldReturnRelevantValues() {
		assertEquals("E2", gumTest.getPosition());
		assertEquals("Doublemint", gumTest.getName());
		assertEquals(BigDecimal.valueOf(6), gumTest.getPrice());
		assertEquals("Gum", gumTest.getType());
		assertEquals(5, gumTest.getStock());
		assertEquals("Chew Chew, Yum!", gumTest.getMessage());
	}

	@Test
	public void settersShouldReturnRelevantValues() {
		gumTest.setName("New Doublemint");
		gumTest.setStock(3);
		gumTest.setPrice(BigDecimal.valueOf(5.0));
		gumTest.setPosition("E3");
		
		assertEquals("New Doublemint", gumTest.getName());
		assertEquals(3, gumTest.getStock());
		assertEquals(BigDecimal.valueOf(5.0), gumTest.getPrice());
		assertEquals("E3", gumTest.getPosition());
	}
	
	@Test
	public void decrementStockShouldChangeStockValue() {
		gumTest.decrementStock();
		gumTest.decrementStock();
		assertEquals(3, gumTest.getStock());
	}
}
