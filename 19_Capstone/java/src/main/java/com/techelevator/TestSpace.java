package com.techelevator;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.*;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;

public class TestSpace {

	public static void main(String[] args) {
		VendingMachine vend = new VendingMachine();
		System.out.println(vend.writeSalesTracker());
		System.out.println(vend.hiddenSalesLog());
//		System.out.println("why");
//		for (Item item : vend.getItems()) {
//			// System.out.println("hmmm");
//			System.out.println(item.getPosition() + " " + item.getName() + " " + item.getPrice().toString() + " "
//					+ item.getType() + " " + item.getMessage());
//		}
		// System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
		//vend.log(VendingMachine.FEED_MONEY, new BigDecimal("20.00"));
		//vend.log(VendingMachine.FEED_MONEY, new BigDecimal("1.00"));
		//vend.log("D3");
		//vend.log(VendingMachine.GIVE_CHANGE, new BigDecimal("0.00"));
		//for (String str : vend.getSalesLog())
		//	System.out.println(str);

		//ZonedDateTime date = ZonedDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss:SS a");
		// String text = date.format(formatter);
		// System.out.println(text);
		// LocalDate parsedDate = LocalDate.parse(text, formatter);
		//System.out.println(date.format(formatter));

		//System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")));

	}

}
