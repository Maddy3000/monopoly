package com.game.monopoly.model;

import com.game.monopoly.constant.CellType;

public class Cell {
	
	private CellType cell;
	private Hotel hotel;
	
	/**
	 * @param cell
	 * @param hotel
	 */
	public Cell(CellType cell, Hotel hotel) {
		this.cell = cell;
		this.hotel = hotel;
	}
	
	public CellType getCell() {
		return cell;
	}
	public void setCell(CellType cell) {
		this.cell = cell;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	@Override
	public String toString() {
		return "Cell [cell=" + cell + ", hotel=" + hotel + "]";
	}
}
