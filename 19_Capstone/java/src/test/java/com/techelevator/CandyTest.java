package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CandyTest {
	Item candyTest = new Candy("A2", "Sour Patch", BigDecimal.valueOf(3.5));
	
	@Test
	public void gettersShouldReturnRelevantValues() {
		assertEquals("A2", candyTest.getPosition());
		assertEquals("Sour Patch", candyTest.getName());
		assertEquals(BigDecimal.valueOf(3.5), candyTest.getPrice());
		assertEquals("Candy", candyTest.getType());
		assertEquals(5, candyTest.getStock());
		assertEquals("Munch Munch, Yum!", candyTest.getMessage());
	}

	@Test
	public void settersShouldReturnRelevantValues() {
		candyTest.setName("New Sour Patch");
		candyTest.setStock(3);
		candyTest.setPrice(BigDecimal.valueOf(4.0));
		candyTest.setPosition("A1");
		
		assertEquals("New Sour Patch", candyTest.getName());
		assertEquals(3, candyTest.getStock());
		assertEquals(BigDecimal.valueOf(4.0), candyTest.getPrice());
		assertEquals("A1", candyTest.getPosition());
	}
	
	@Test
	public void decrementStockShouldChangeStockValue() {
		candyTest.decrementStock();
		candyTest.decrementStock();
		assertEquals(3, candyTest.getStock());
	}
}
