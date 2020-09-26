package com.game.monopoly.service;

import org.springframework.boot.CommandLineRunner;

import com.game.monopoly.model.Player;

public interface IPlayGame extends CommandLineRunner {
	
	void setup();
	Player play();
}
