package com.techelevator;

import java.time.*;
import java.time.format.*;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;

public class TestSpace {

	public static void main(String[] args) {
//		VendingMachine vend = new VendingMachine();
//		System.out.println("why");
//		for (Item item : vend.getItems()) {
//			// System.out.println("hmmm");
//			System.out.println(item.getPosition() + " " + item.getName() + " " + item.getPrice().toString() + " "
//					+ item.getType() + " " + item.getMessage());
//		}
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));

		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[MM/dd/yyyy]");
		String text = date.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
		System.out.println(parsedDate.format(formatter));

	}

}
