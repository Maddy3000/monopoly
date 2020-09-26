package com.game.monopoly.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Players implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 6957020953593436179L;
	
	private static volatile Players instance;
	private final List<Player> players;
	
	private Players(List<Player> players) {
		if(instance != null) {
			throw new RuntimeException("Use getInstance method to get instance of this class");
		}
		
		this.players = Collections.unmodifiableList(players);
	}
	
	public static Players getInstance(List<Player> players) {
		if(instance == null) {
			synchronized (Players.class) {
				if(instance == null) {
					instance = new Players(players);
				}
			}
		}
		
		return instance;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	protected Players readResolve() {
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot close this class, use getInstance method to get instance of this class");
	}
}
