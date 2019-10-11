package com.techelevator;

import java.util.Collections;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	
	private Menu menu;
	private VendingMachine vendingMachine = new VendingMachine();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayVendingMachineItems(vendingMachine);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenuRun(menu);
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for shopping, see you next time!");
				return;
			} 
		}
	}
	
	public static void purchaseMenuRun(Menu menu) {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			System.out.println();
			System.out.println("Current Money Provided: $");
			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				// feed money
			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				// select product
			} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				// finish transaction
			}
		}
	}
	
	public static void displayVendingMachineItems(VendingMachine vendingMachine) {
		System.out.println();
		System.out.println("*Available Items*");
		System.out.println("Slot Location          Product Name           "
				+ "Price                  Type");
		System.out.println(String.join("", Collections.nCopies(80, "=")));
		for (Item item : vendingMachine.getItems()) {
			int itemStock = item.getStock();
			if (itemStock > 0) {
				String itemPosition = item.getPosition();
				String itemName = item.getName();
				String itemPrice = "$" + item.getPrice();
				String itemType = item.getType();
				
				System.out.println(itemPosition + generateSpace(itemPosition) +
						itemName + generateSpace(itemName) + 
						itemPrice + generateSpace(itemPrice) +
						itemType);
			}
		}
	}
	
	public static String generateSpace(String str) {
		int spaceLength = 23 - str.length();
		String space = "";
		
		for (int i = 1; i <= spaceLength; i++) {
			space += " ";
		}
		
		return space;
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
