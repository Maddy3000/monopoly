package com.game.monopoly.model;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 3495349708961564124L;

	private static volatile Board instance;
	private List<Cell> cells;
	
	private Board() {
		if(instance != null) {
			throw new RuntimeException("Use getInstance method to get instance of this class");
		}
	}
	
	public static Board getInstance() {
		if(instance == null) {
			synchronized (Board.class) {
				if(instance == null) {
					instance = new Board();
				}
			}
		}
		return instance;
	}
	
	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
	
	protected Board readResolve() {
		return getInstance();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot close this class, use getInstance method to get instance of this class");
	}
}
