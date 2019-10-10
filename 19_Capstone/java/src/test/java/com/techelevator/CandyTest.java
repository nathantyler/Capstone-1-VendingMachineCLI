package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CandyTest {

	Item candyTest = new Candy("Sour Patch", BigDecimal.valueOf(3.5));
	
	@Test
	public void gettersShouldReturnRelevantValues() {
		assertEquals("Sour Patch", candyTest.getName());
		assertEquals(BigDecimal.valueOf(3.5), candyTest.getPrice());
		assertEquals("Candy", candyTest.getType());
	}

}
