package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandyTest {

	Item candyTest = new Candy();
	
	@Test
	public void test() {
		assertEquals("sourpatch", candyTest.getName());
	}

}
