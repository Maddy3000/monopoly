package com.game.monopoly.model;

import org.apache.commons.lang3.RandomUtils;

public class Hotel {

	private int id;
	private Player owner;

	public Hotel() {
		this.id = RandomUtils.nextInt(1, 1000);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", owner=" + owner + "]";
	}
}
