package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

	private List<Item> items;
	private List<Chips> chips;
	private List<Candy> candies;
	private List<Drink> drinks;
	private List<Gum> gums;

	/**
	 * 
	 */
	public VendingMachine() {
		items = new ArrayList<Item>();
		chips = new ArrayList<Chips>();
		candies = new ArrayList<Candy>();
		gums = new ArrayList<Gum>();
	}

	private void populateItems() throws IOException {
		File file = new File("vendingmachine.csv");
		try (Scanner reader = new Scanner(file.getAbsoluteFile())) {
			
		} catch (Exception e) {
			System.out.println("Problem encountered. The file vendingmachine.csv is probably missing. Exiting.");
			System.exit(1);
		}
	}

}
