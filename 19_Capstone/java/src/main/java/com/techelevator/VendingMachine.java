package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] itemsStrings = line.split("|");
				Item item = new Item(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
				items.add(item);
				//if (itemsStrings[3].equals("Chip")) 
					
				
			}
		} catch (Exception e) {
			System.out.println("Problem encountered. The file vendingmachine.csv is probably missing. Exiting.");
			System.exit(1);
		}
	}

}
