package com.techelevator;

import java.math.BigDecimal;

public class Item {

	protected String name, position;
	protected static String type, message;
	protected int stock;
	protected BigDecimal price;

	/**
	 * @param name
	 * @param price
	 */
	public Item(String name, BigDecimal price) {
		type = "Item";
		stock = 5;
		this.name = name;
		this.price = price;
	}
	
	/**
	 * 
	 */
	public Item() {
		stock = 5;
		type = "Item";
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void decrementStock() {
		stock--;
	}

}
