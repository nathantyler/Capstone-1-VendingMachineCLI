package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemTest {
	Item candyTest = new Candy("A2", "Sour Patch", BigDecimal.valueOf(3.5));
	Item chipsTest = new Chips("C3", "Lay's", BigDecimal.valueOf(2));
	Item drinkTest = new Drink("D5", "Pepsi", BigDecimal.valueOf(1));
	Item gumTest = new Gum("E2", "Doublemint", BigDecimal.valueOf(6));
	
	@Test
	public void itemInteractionWouldWork() {
		assertEquals("Sour Patch", candyTest.getName());
		assertEquals("Lay's", chipsTest.getName());
		assertEquals("Pepsi", drinkTest.getName());
		assertEquals("Doublemint", gumTest.getName());
		
		assertEquals("Chew Chew, Yum!", gumTest.getMessage());
		assertEquals("Crunch Crunch, Yum!", chipsTest.getMessage());
		assertEquals("Glug Glug, Yum!", drinkTest.getMessage());
		assertEquals("Munch Munch, Yum!", candyTest.getMessage());
		
		assertEquals("Gum", gumTest.getType());
		assertEquals("Chip", chipsTest.getType());
		assertEquals("Drink", drinkTest.getType());
		assertEquals("Candy", candyTest.getType());
		
		assertEquals(5, gumTest.getStock());
		gumTest.decrementStock();
		
		assertEquals(5, chipsTest.getStock());
		chipsTest.decrementStock();
		
		assertEquals(5, drinkTest.getStock());
		drinkTest.decrementStock();
		
		assertEquals(5, candyTest.getStock());
		candyTest.decrementStock();
		
		assertEquals(4, gumTest.getStock());
		assertEquals(4, chipsTest.getStock());
		assertEquals(4, drinkTest.getStock());
		assertEquals(4, candyTest.getStock());
		
		assertEquals("A2", candyTest.getPosition());
		assertEquals("C3", chipsTest.getPosition());
		assertEquals("D5", drinkTest.getPosition());
		assertEquals("E2", gumTest.getPosition());
	}
}
