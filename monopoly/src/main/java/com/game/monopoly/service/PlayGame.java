package com.game.monopoly.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.monopoly.config.MonopolyPorperties;
import com.game.monopoly.constant.CellType;
import com.game.monopoly.model.Board;
import com.game.monopoly.model.Cell;
import com.game.monopoly.model.Hotel;
import com.game.monopoly.model.Player;
import com.game.monopoly.model.Players;

@Service
public class PlayGame implements IPlayGame {

	private static Logger logger = LoggerFactory.getLogger(PlayGame.class);

	@Autowired
	private IGameSetupService setupGameService;

	@Autowired
	private IPlayerService playerService;

	@Autowired
	private MonopolyPorperties properties;

	private Board board;
	private Players players;

	@Override
	public void run(String... args) throws Exception {

		try {

			setup();
			Player winner = play();

			players.getPlayers().forEach(player -> {
				int assetAmount = getAssetAmount(player.getHotels());
				logger.info(player.getName() + " has total worth " + (player.getAmount() + assetAmount));
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setup() {
		board = setupGameService.initBoard();
		players = setupGameService.initPlayers();
	}
	
	@Override
	public Player play() {

		int[] diceOutputs = properties.getDiceOutputs();

		int diceRollCounter = -1;
		int round = 1;

		while(diceRollCounter < diceOutputs.length - 1) {
			
			logger.info("Round: {}", round++);
			for(Player player : players.getPlayers()) {

				//Roll the dice
				logger.info("{} is rolling dice", player.getName());
				diceRollCounter++;

				//Get dice value
				int diceValue = diceOutputs[diceRollCounter];
				logger.info("{} gets {}", player.getName(), diceValue);

				//Move the player
				move(player, diceValue);
				logger.info("{} moves at cell {} which is {}",
						player.getName(),
						player.getCellPosition(),
						board.getCells().get(player.getCellPosition()).getCell().getKey());

				//Take action
				String actionPerformed = takeAction(player);
				logger.info("{} performs action: {}", player.getName(), actionPerformed);
				
				logger.info("\n\n");
			}
			logger.info("=========================================================================== \n\n");
		}

		return null;
	}

	private void move(Player player, int diceValue) {
		int currentPosition = player.getCellPosition();
		int newPosition = (currentPosition + diceValue) % board.getCells().size();
		player.setCellPosition(newPosition);
	}

	private String takeAction(Player player) {

		String actionPerformed;
		Cell cell = board.getCells().get(player.getCellPosition());

		switch (cell.getCell()) {
		case J:
			player.setAmount(player.getAmount() - CellType.J.getValue());
			actionPerformed = "Jail Fine";
			break;
		case H:

			Hotel hotel = cell.getHotel();
			Player owner = hotel.getOwner();

			if(owner == null) {
				playerService.buy(player, hotel);
				actionPerformed = "Bought Hotel";
			} else {
				playerService.payRent(owner, player, 50);
				actionPerformed = "Paid Rent";
			}

			break;
		case T:
			player.setAmount(player.getAmount() + CellType.T.getValue());
			actionPerformed = "Found Treasure";
			break;
		case E:
			actionPerformed = "Nothing";
			break;
		default:
			actionPerformed = "Invalid Cell";
			break;
		}
		
		return actionPerformed;
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

}
