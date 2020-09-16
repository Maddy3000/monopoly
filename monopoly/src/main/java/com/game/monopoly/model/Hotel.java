package com.game.monopoly.model;

public class Hotel {

	private int id;
	private String name;
	private Player owner;

	/**
	 * @param id
	 * @param name
	 */
	public Hotel(int id, String name) {
		this.id = id;
		this.name = name;
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
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", owner=" + owner + "]";
	}
}
