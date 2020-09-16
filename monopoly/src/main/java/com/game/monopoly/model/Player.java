package com.game.monopoly.model;

import java.util.List;

public class Player {

	private int id;
	private String name;
	private int amount;
	private int cellPosition;
	
	private List<Hotel> hotels;

	/**
	 * @param id
	 * @param name
	 * @param amount
	 * @param cellPosition
	 * @param hotels
	 */
	public Player(int id, String name, int amount, int cellPosition, List<Hotel> hotels) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.cellPosition = cellPosition;
		this.hotels = hotels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCellPosition() {
		return cellPosition;
	}

	public void setCellPosition(int cellPosition) {
		this.cellPosition = cellPosition;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", amount=" + amount + ", cellPosition=" + cellPosition
				+ ", hotels=" + hotels + "]";
	}
}
