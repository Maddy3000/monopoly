package com.game.monopoly.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.monopoly.config.MonopolyPorperties;
import com.game.monopoly.constant.CellType;
import com.game.monopoly.model.Board;
import com.game.monopoly.model.Cell;
import com.game.monopoly.model.Player;
import com.game.monopoly.model.Players;

@Service
public class GameSetupService implements IGameSetupService {
	
	@Autowired
	private MonopolyPorperties properties;

	@Override
	public Board initBoard() {
		
		Board board = Board.getInstance();
		List<Cell> cells = new ArrayList<>();

		for(String strCell : properties.getSetup().getCells()) {
			
			CellType cellType = CellType.valueOf(strCell);
			Cell cell = new Cell.Builder()
					.withCell(cellType)
					.build();
			
			cells.add(cell);
		}
		
		board.setCells(cells);
		
		return board;	
	}

	@Override
	public Players initPlayers() {
		
		int noOfPlayers = properties.getSetup().getNoOfPlayers();
		String[] playerNames = properties.getSetup().getPlayerNames();
		
		if(noOfPlayers != playerNames.length) {
			throw new RuntimeException("Count of player names does not match with no of players");
		}
		
		List<Player> players = Stream.of(playerNames)
				.map(playerName -> {
					return new Player.Builder(playerName)
							.withAmount(1000)
							.withoutHotel()
							.startFromCell(0)
							.build();
				})
				.collect(Collectors.toList());
		
		return Players.getInstance(players);
	}
}
