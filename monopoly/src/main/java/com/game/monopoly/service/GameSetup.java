package com.game.monopoly.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.game.monopoly.constant.CellType;
import com.game.monopoly.model.Board;
import com.game.monopoly.model.Cell;
import com.game.monopoly.model.Hotel;
import com.game.monopoly.model.Player;

@Service
public class GameSetup implements IGameSetup {

	@Override
	public Board initBoard(String strCells) {
		
		Board board = new Board();
		List<Cell> cells = new ArrayList<>();

		String[] split = StringUtils.split(strCells, ",");
		for(String cellType : split) {
			Random random = new Random();
			cells.add(new Cell(CellType.valueOf(cellType), new Hotel(random.nextInt(), "Hotel")));
		}
		
		board.setCells(cells);
		
		return board;	
	}

	@Override
	public List<Player> initPlayers(int numberOfPlayers) {
		
		List<Player> players = new ArrayList<>();
		
		for(int i=0; i<numberOfPlayers; i++) {
			players.add(new Player((i+1), String.join("-", "Player", String.valueOf(i)), 1000, 0, new ArrayList<>()));
		}
		
		return players;
	}
	
	public Map<Player, Integer> getDiceOutputs(String diceOutputs, List<Player> players) {
		Map<Player, Integer> playerDiceMap = new LinkedHashMap<>();
		
		String[] diceOutputList = StringUtils.split(diceOutputs, ",");
		int noOfDiceOutputs = StringUtils.split(diceOutputs, ",").length;
		int playerCounter = 0;
		int tempCounter = 0;
		
		while (noOfDiceOutputs != 0) {
			
			playerDiceMap.put(players.get(playerCounter), Integer.valueOf(diceOutputList[tempCounter]));
			if(playerCounter == players.size()-1) {
				playerCounter = 0;
			} else {
				playerCounter++;
			}
			
			tempCounter++;
			noOfDiceOutputs--;
		}
		
		return playerDiceMap;
	}
}
