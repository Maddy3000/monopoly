package com.game.monopoly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class Player {

	private int id;
	private String name;
	private int amount;
	private int cellPosition;
	private List<Hotel> hotels;

	private Player(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.amount = builder.amount;
		this.cellPosition = builder.cellPosition;
		this.hotels = builder.hotels;
	}

	public static class Builder {
		
		private int id;
		private String name;
		private int amount;
		private int cellPosition;
		private List<Hotel> hotels;
		
		public Builder(String name) {
			this.id = RandomUtils.nextInt(1, 1000);
			this.name = name;
		}
		
		public Builder withAmount(int amount) {
			this.amount = amount;
			return this;
		}
		
		public Builder startFromCell(int cellPosition) {
			this.cellPosition = cellPosition;
			return this;
		}
		
		public Builder withoutHotel() {
			this.hotels = new ArrayList<>();
			return this;
		}
		
		public Player build() {
			return new Player(this);
		}
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

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", amount=" + amount + ", cellPosition=" + cellPosition + "]";
	}
}
