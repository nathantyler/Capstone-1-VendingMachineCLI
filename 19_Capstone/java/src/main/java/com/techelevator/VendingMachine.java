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
	private BigDecimal userBalance;

	public VendingMachine() {
		items = new ArrayList<Item>();
		chips = new ArrayList<Chips>();
		candies = new ArrayList<Candy>();
		drinks = new ArrayList<Drink>();
		gums = new ArrayList<Gum>();
		
		try {
			populateItems();
		} catch (Exception e) {
			System.out.println("Problem! vendingmachine.csv most likely not present.");
		}
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public BigDecimal getUserBalance() {
		return userBalance;
	}

	public List<Chips> getChips() {
		return chips;
	}

	public List<Candy> getCandies() {
		return candies;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public List<Gum> getGums() {
		return gums;
	}
	
	public void addMoneyToMachine(BigDecimal money) {
		userBalance = userBalance.add(money);
	}
	
	private void populateItems() throws IOException {
		File file = new File("vendingmachine.csv");
		try (Scanner reader = new Scanner(file.getAbsoluteFile())) {
			
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] itemsStrings = line.split("\\|");
				if (itemsStrings[3].equals("Chip")) {
					Chips chip = new Chips(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
					chips.add(chip);
					items.add(chip);
				} else if (itemsStrings[3].equals("Candy")) {
					Candy candy = new Candy(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
					candies.add(candy);
					items.add(candy);
				} else if (itemsStrings[3].equals("Drink")) {
					Drink drink = new Drink(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
					drinks.add(drink);
					items.add(drink);
				} else if (itemsStrings[3].equals("Gum")) {
					Gum gum = new Gum(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
					gums.add(gum);
					items.add(gum);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Problem encountered. The file vendingmachine.csv is probably missing. Exiting.");
			System.exit(1);
		}
	}

}
