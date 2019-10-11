package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	public static final int FEED_MONEY = 1, GIVE_CHANGE = 2;
	private static final String FEED_MONEY_STR = " FEED MONEY ", GIVE_CHANGE_STR = " GIVE CHANGE ";
	private static final String INVENTORY_FILE_NAME = "vendingmachine.csv";
	private static final String CHIP_TYPE = "Chip", CANDY_TYPE = "Candy", DRINK_TYPE = "Drink", GUM_TYPE = "Gum";
	private static final String LOG_FILE_NAME = "log.txt";
	private List<Item> items;
	private List<Chips> chips;
	private List<Candy> candies;
	private List<Drink> drinks;
	private List<Gum> gums;
	private Map<String, Item> itemSelector;
	private BigDecimal userBalance;
	private List<String> salesLog;
	private File logFile;

	public VendingMachine() {
		items = new ArrayList<Item>();
		chips = new ArrayList<Chips>();
		candies = new ArrayList<Candy>();
		drinks = new ArrayList<Drink>();
		gums = new ArrayList<Gum>();
		itemSelector = new HashMap<String, Item>();
		userBalance = new BigDecimal("0.00");
		salesLog = new ArrayList<String>();
		logFile = new File(LOG_FILE_NAME);
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (Exception e) {

			}

		}
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

	public Map<String, Item> getItemSelector() {
		return itemSelector;
	}

	public List<String> getSalesLog() {
		return salesLog;
	}

	public void addMoneyToMachine(BigDecimal money) {
		userBalance = userBalance.add(money);
	}

	public void dockMoneyOnMachine(BigDecimal itemPrice) {
		userBalance = userBalance.subtract(itemPrice);
	}

	/*
	 * Hey, Guan: Here are a few utility methods that may make things easier for
	 * you. Use them if it helps. We can remove what we don't need, but I think some
	 * may be very useful and make the code short/cleaner/nicer or at least more
	 * readable.
	 */

	public boolean itemAtPositionExists(String position) {
		return itemSelector.get(position) != null;
	}

	/* returns -1 if there is no item at that position */
	public int getItemStock(String position) {
		Item itemAtPosition = itemSelector.get(position);

		if (itemAtPosition != null) {
			return itemAtPosition.getStock();
		}

		return -1;
	}

	/* returns null if there is no item at that position. */
	public String getItemMessage(String position) {
		return itemSelector.get(position) != null ? itemSelector.get(position).getMessage() : null;
	}

	/* returns null if there is no item at that position. */
	public String getItemType(String position) {
		return itemSelector.get(position) != null ? itemSelector.get(position).getType() : null;
	}

	/* returns null if there is no item at that position. */
	public String getItemName(String position) {
		return itemSelector.get(position) != null ? itemSelector.get(position).getName() : null;
	}

	/*
	 * This will return the items price. If the item at that position doesn't exist,
	 * it returns -1. Actually I may change this to be in line with the rest of the
	 * item getters and make it return null if unsuccessful. What do you think?
	 */
	public BigDecimal getItemPrice(String position) {
		return itemSelector.get(position) != null ? itemSelector.get(position).getPrice() : BigDecimal.valueOf(-1);
	}

	public boolean decrementItemAtPosition(String position) {
		boolean decrementSuccesful = false;
		Item itemAtPosition = itemSelector.get(position);
		if (itemAtPosition.getStock() > 0 && itemAtPosition != null)
			itemAtPosition.decrementStock();
		return decrementSuccesful;
	}

	/* nickels, dimes, and quarters */
	public String getChangeFromMachine() {
		int balanceNoDecimal = userBalance.multiply(BigDecimal.valueOf(100)).intValue();
		int quarters = balanceNoDecimal / 25;
		int dimes = (balanceNoDecimal - (quarters * 25)) / 10;
		int nickels = (balanceNoDecimal - (quarters * 25 + dimes * 10)) / 5;

		String quarterAmount = "", dimeAmount = "", nickelAmount = "";
		if (quarters == 1) {
			quarterAmount = quarters + " quarter";
		} else if (quarters > 1) {
			quarterAmount = quarters + " quarters";
		}

		if (dimes == 1) {
			dimeAmount = quarters > 0 ? " and " + dimes + " dime" : dimes + " dime";
		} else if (dimes > 1) {
			dimeAmount = quarters > 0 ? " and " + dimes + " dimes" : dimes + " dimes";
		}

		if (nickels == 1) {
			nickelAmount = (quarters > 0 || dimes > 0) ? " and " + nickels + " nickel" : nickels + "nickel";
		} else if (nickels > 1) {
			nickelAmount = (quarters > 0 || dimes > 0) ? " and " + nickels + " nickels" : nickels + "nickels";
		}

		if ((quarterAmount + dimeAmount + nickelAmount).equals("")) {
			return "You have spent all your money or have not added money yet. Thanks for shopping!";
		}

		userBalance = BigDecimal.valueOf(0);
		return "Here is your change: " + quarterAmount + dimeAmount + nickelAmount + ". Have a great day!";
	}

	private void populateItems() throws IOException {
		File file = new File(INVENTORY_FILE_NAME);
		try (Scanner reader = new Scanner(file.getAbsoluteFile())) {

			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] itemsStrings = line.split("\\|");
				if (itemsStrings[3].equals(CHIP_TYPE)) {
					Chips chip = new Chips(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
					chips.add(chip);
					items.add(chip);
					itemSelector.put(chip.getPosition(), chip);
				} else if (itemsStrings[3].equals(CANDY_TYPE)) {
					Candy candy = new Candy(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
					candies.add(candy);
					items.add(candy);
					itemSelector.put(candy.getPosition(), candy);
				} else if (itemsStrings[3].equals(DRINK_TYPE)) {
					Drink drink = new Drink(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
					drinks.add(drink);
					items.add(drink);
					itemSelector.put(drink.getPosition(), drink);
				} else if (itemsStrings[3].equals(GUM_TYPE)) {
					Gum gum = new Gum(itemsStrings[0], itemsStrings[1], new BigDecimal(itemsStrings[2]));
					gums.add(gum);
					items.add(gum);
					itemSelector.put(gum.getPosition(), gum);
				}
			}

		} catch (Exception e) {
			System.out.println("Problem encountered. The file vendingmachine.csv is probably missing. Exiting.");
			System.exit(1);
		}
	}

	public boolean log(int transaction, BigDecimal amount) {
		String transStr = "", logStr = "";
		if (transaction == FEED_MONEY)
			transStr = FEED_MONEY_STR;
		if (transaction == GIVE_CHANGE)
			transStr = GIVE_CHANGE_STR;
		logStr = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + transStr + "$"
				+ amount.toString() + " $" + userBalance.toString();
		salesLog.add(logStr);
		logToFile(logStr);
		return !transStr.isEmpty();
	}

	public boolean log(String position) {
		String logStr = "";
		Item itemInQuestion = itemSelector.get(position);
		if (itemInQuestion != null) {
			logStr = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " "
					+ itemInQuestion.getName() + " " + itemInQuestion.getPosition() + " $"
					+ userBalance.add(itemInQuestion.getPrice()).toString() + " $" + userBalance.toString();
			salesLog.add(logStr);
			logToFile(logStr);
		}
		return itemInQuestion != null;
	}

	public boolean logToFile(String logStr) {
		try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(logFile.getAbsoluteFile(), true))) {
			logWriter.append(logStr + "\n");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}