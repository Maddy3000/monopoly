package com.game.monopoly.model;

import com.game.monopoly.constant.CellType;

public class Cell {
	
	private CellType cell;
	private Hotel hotel;
	
	private Cell(Builder builder) {
		this.cell = builder.cell;
		this.hotel = builder.hotel;
	}
	
	public CellType getCell() {
		return cell;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public static class Builder {
		
		private CellType cell;
		private Hotel hotel;
		
		public Builder withCell(CellType cell) {
			this.cell = cell;
			if(cell == CellType.H) {
				this.hotel = new Hotel();
			}
			return this;
		}
		
		public Cell build() {
			return new Cell(this);
		}
	}
}
