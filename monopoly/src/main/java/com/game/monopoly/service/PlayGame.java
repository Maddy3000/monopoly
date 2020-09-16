package com.game.monopoly.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.monopoly.constant.CellType;
import com.game.monopoly.exception.InsufficientFundsException;
import com.game.monopoly.model.Board;
import com.game.monopoly.model.Cell;
import com.game.monopoly.model.Hotel;
import com.game.monopoly.model.Player;

@Service
public class PlayGame implements IPlayGame {

	private static Log logger = LogFactory.getLog(PlayGame.class);

	@Autowired
	private GameSetup gameSetup;

	@Override
	public int rollDice(int round, int playerId) {

		return 0;
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		try {
			logger.info("Number of players : ");
			int numberOfPlayers = sc.nextInt();

			sc.nextLine();
			logger.info("Cell position and type : ");
			String strCells = sc.nextLine();

			logger.info("Dice outputs for all players : ");
			String diceOutputs = sc.nextLine();

			Board board = gameSetup.initBoard(strCells);
			List<Player> players = gameSetup.initPlayers(numberOfPlayers);
			Map<Player, Integer> playerDiceMap = gameSetup.getDiceOutputs(diceOutputs, players);
			List<Cell> cells = board.getCells();

			for(Entry<Player, Integer> playerDice : playerDiceMap.entrySet()) {

				Player player = playerDice.getKey();
				int diceValue = playerDice.getValue().intValue();

				int currentLocation = player.getCellPosition();
				int cellIndex = (currentLocation + diceValue) % cells.size();

				player.setCellPosition(cellIndex);

				Cell targetCell = cells.get(cellIndex);
				processCell(player, board, targetCell);
			}
			
			players.forEach(player -> {
				int assetAmount = getAssetAmount(player.getHotels());
				logger.info(player.getName() + " has total worth " + player.getAmount() + assetAmount);
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	private static int getAssetAmount(List<Hotel> hotels) {
		int amount = 0;
		if (!hotels.isEmpty()) {
			for (Hotel hotel : hotels) {
				amount = amount + CellType.H.getValue();
			}
		}
		return amount;
	}

	private void processCell(Player player, Board board, Cell cell) {

		switch (cell.getCell()) {
		case J:
			player.setAmount(player.getAmount() - CellType.J.getValue());
			break;
		case H:


			Hotel hotel = cell.getHotel();
			Player owner = hotel.getOwner();

			if(owner == null) {
				buyHotel(player, board, hotel);
			} else {
				payRent(player, owner, 50);
			}

			break;
		case T:
			player.setAmount(player.getAmount() + CellType.T.getValue());
			break;
		case E:
			break;
		default:
			break;
		}

	}

	private void payRent(Player player, Player owner, int rent) {
		if (player.getAmount() >= CellType.H.getValue()) {
			owner.setAmount(owner.getAmount() + rent);
			player.setAmount(player.getAmount() - rent);
		} else {
			throw new InsufficientFundsException("You don't have enough money to pay rent");

		}
	}

	private void buyHotel(Player player, Board board, Hotel hotel) {

		if(player.getAmount() >= CellType.H.getValue()) {
			player.setAmount(player.getAmount() - CellType.H.getValue());
			hotel.setOwner(player);
			player.getHotels().add(hotel);
		} else {
			throw new InsufficientFundsException("You don't have enough money to buy this hotel");
		}
	}

}
