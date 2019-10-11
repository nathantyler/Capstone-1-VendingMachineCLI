package com.techelevator;

import java.math.BigDecimal;
import java.util.Collections;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, 
														MAIN_MENU_OPTION_PURCHASE, 
														MAIN_MENU_OPTION_EXIT };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, 
															PURCHASE_MENU_OPTION_SELECT_PRODUCT, 
															PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	
	private static final BigDecimal FEED_MONEY_MENU_1_DOLLAR = new BigDecimal("1.00");
	private static final BigDecimal FEED_MONEY_MENU_2_DOLLAR = new BigDecimal("2.00");
	private static final BigDecimal FEED_MONEY_MENU_5_DOLLAR = new BigDecimal("5.00");
	private static final BigDecimal FEED_MONEY_MENU_10_DOLLAR = new BigDecimal("10.00");
	private static final BigDecimal FEED_MONEY_MENU_20_DOLLAR = new BigDecimal("20.00");
	private static final BigDecimal[] FEED_MONEY_MENU_OPTIONS = { FEED_MONEY_MENU_1_DOLLAR, 
																  FEED_MONEY_MENU_2_DOLLAR, 
																  FEED_MONEY_MENU_5_DOLLAR,
																  FEED_MONEY_MENU_10_DOLLAR, 
																  FEED_MONEY_MENU_20_DOLLAR };
	private static final String FEED_MONEY_CONTINUE = "Add more money.";
	private static final String FEED_MONEY_EXIT = "I am done.";
	private static final String[] FEED_MONEY_EXIT_MENU_OPTIONS = { FEED_MONEY_CONTINUE, 
																   FEED_MONEY_EXIT };
	private Menu menu;
	private VendingMachine vendingMachine;

	public VendingMachineCLI(Menu menu, VendingMachine vendingMachine) {
		this.menu = menu;
		this.vendingMachine = vendingMachine;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayVendingMachineItems(vendingMachine);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenuRun(menu, vendingMachine);
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for shopping, see you next time!");
				return;
			} 
		}
	}
	
	public static void purchaseMenuRun(Menu menu, VendingMachine vendingMachine) {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				feedMoney(menu, vendingMachine);
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
	
	public static void feedMoney(Menu menu, VendingMachine vendingMachine) {
		System.out.println("Hi there! Please insert a bill, "
				+ "we only accept $1, $2, $5, $10, $20, thank you!");
		BigDecimal choice = (BigDecimal) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);
		
		if (choice.equals(FEED_MONEY_MENU_1_DOLLAR)  || 
			choice.equals(FEED_MONEY_MENU_2_DOLLAR)  ||
			choice.equals(FEED_MONEY_MENU_5_DOLLAR)  ||
			choice.equals(FEED_MONEY_MENU_10_DOLLAR) ||
			choice.equals(FEED_MONEY_MENU_20_DOLLAR) ) {
			vendingMachine.addMoneyToMachine(choice);
			System.out.println();
			System.out.println("$" + choice + " added to your balance successfully!");
		} 
		
		System.out.println();
		System.out.println("Current Money Provided: $" + vendingMachine.getUserBalance());
		
		System.out.println();
		System.out.println("Would you like to add more money?");
		String feedMore = (String) menu.getChoiceFromOptions(FEED_MONEY_EXIT_MENU_OPTIONS);
		if (feedMore.equals(FEED_MONEY_CONTINUE)) {
			feedMoney(menu, vendingMachine);
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachine vendingMachine = new VendingMachine();
		VendingMachineCLI cli = new VendingMachineCLI(menu, vendingMachine);
		cli.run();
	}
}
