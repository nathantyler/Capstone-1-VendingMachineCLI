package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ChipsTest {
	Item chipsTest = new Chips("C3", "Lay's", BigDecimal.valueOf(2));
	
	@Test
	public void gettersShouldReturnRelevantValues() {
		assertEquals("C3", chipsTest.getPosition());
		assertEquals("Lay's", chipsTest.getName());
		assertEquals(BigDecimal.valueOf(2), chipsTest.getPrice());
		assertEquals("Chip", chipsTest.getType());
		assertEquals(5, chipsTest.getStock());
		assertEquals("Crunch Crunch, Yum!", chipsTest.getMessage());
	}

	@Test
	public void settersShouldReturnRelevantValues() {
		chipsTest.setName("New Lay's");
		chipsTest.setStock(3);
		chipsTest.setPrice(BigDecimal.valueOf(1.0));
		chipsTest.setPosition("C1");
		
		assertEquals("New Lay's", chipsTest.getName());
		assertEquals(3, chipsTest.getStock());
		assertEquals(BigDecimal.valueOf(1.0), chipsTest.getPrice());
		assertEquals("C1", chipsTest.getPosition());
	}
	
	@Test
	public void decrementStockShouldChangeStockValue() {
		chipsTest.decrementStock();
		chipsTest.decrementStock();
		assertEquals(3, chipsTest.getStock());
	}

}
