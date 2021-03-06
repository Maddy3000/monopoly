package com.game.monopoly.constant;

public enum CellType {
	
	E("Empty", 0),
	J("Jail", 150),
	T("Treasure", 200),
	H("Hotel", 200);

	String key;
	int value;

	private CellType(String key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}
}
