package com.game.monopoly.service;

import java.util.List;

import com.game.monopoly.model.Board;
import com.game.monopoly.model.Player;

public interface IGameSetup {
	
	Board initBoard(String cells);
	List<Player> initPlayers(int numberOfPlayers);
}
