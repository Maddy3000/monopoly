package com.game.monopoly.service;

import org.springframework.boot.CommandLineRunner;

public interface IPlayGame extends CommandLineRunner {
	
	public int rollDice(int round, int playerId);
}
