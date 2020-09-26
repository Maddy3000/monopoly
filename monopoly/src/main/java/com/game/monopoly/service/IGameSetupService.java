package com.game.monopoly.service;

import com.game.monopoly.model.Board;
import com.game.monopoly.model.Players;

public interface IGameSetupService {
	
	Board initBoard();
	Players initPlayers();
}
