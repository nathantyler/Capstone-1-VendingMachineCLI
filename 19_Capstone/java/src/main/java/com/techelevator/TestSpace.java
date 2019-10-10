package com.techelevator;

public class TestSpace {

	public static void main(String[] args) {
		VendingMachine vend = new VendingMachine();
		System.out.println("why");
		for (Item item : vend.getItems()) {
			// System.out.println("hmmm");
			System.out.println(item.getPosition() + " " + item.getName() + " " + item.getPrice().toString() + " "
					+ item.getType() + " " + item.getMessage());
		}

	}

}
