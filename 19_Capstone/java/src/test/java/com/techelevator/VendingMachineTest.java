package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendingMachineTest {
	VendingMachine vendingMachineTest = new VendingMachine();
	
	@Test
	public void listOfItemsShouldBeGeneratedCorrectlyInVendingMachine() {		
		assertEquals(16, vendingMachineTest.getItems().size());
		assertTrue(vendingMachineTest.getItems().get(0).getType().equals("Chip"));
		assertTrue(vendingMachineTest.getItems().get(6).getType().equals("Candy"));
		assertTrue(vendingMachineTest.getItems().get(10).getType().equals("Drink"));
		assertTrue(vendingMachineTest.getItems().get(15).getType().equals("Gum"));
	}
}
