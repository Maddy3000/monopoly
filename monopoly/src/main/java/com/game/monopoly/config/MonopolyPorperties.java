package com.game.monopoly.config;

import java.util.Arrays;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "game.monopoly")
public class MonopolyPorperties {
	
	private final int[] diceOutputs;
	private final Setup setup;
	
	public static class Setup {
		private final int noOfPlayers;
		private final String[] playerNames;
		private final String[] cells;
		
		public Setup(int noOfPlayers, String[] playerNames, String[] cells) {
			this.noOfPlayers = noOfPlayers;
			this.playerNames = playerNames;
			this.cells = cells;
		}
		
		public int getNoOfPlayers() {
			return noOfPlayers;
		}
		public String[] getPlayerNames() {
			return playerNames;
		}
		public String[] getCells() {
			return cells;
		}
		
		@Override
		public String toString() {
			return "Setup [noOfPlayers=" + noOfPlayers + ", playerNames=" + Arrays.toString(playerNames) + ", cells="
					+ Arrays.toString(cells) + "]";
		}
	}
	
	public MonopolyPorperties(int[] diceOutputs, Setup setup) {
		this.diceOutputs = diceOutputs;
		this.setup = setup;
	}

	public int[] getDiceOutputs() {
		return diceOutputs;
	}

	public Setup getSetup() {
		return setup;
	}
}
