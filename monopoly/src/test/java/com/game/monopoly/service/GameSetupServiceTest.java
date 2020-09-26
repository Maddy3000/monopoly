package com.game.monopoly.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.game.monopoly.model.Board;
import com.game.monopoly.model.Players;

@SpringBootTest
public class GameSetupServiceTest {
	
	private final IGameSetupService setupGameService;
	
	@Autowired
	public GameSetupServiceTest(IGameSetupService setupGameService) {
		this.setupGameService = setupGameService;
	}
	
	@Test
	@DisplayName("Test for setting up Monopoly Board")
	public void testInitBoard() {
		
		Board board = setupGameService.initBoard();

		assertNotNull(board);
		assertNotNull(board.getCells());
	}
	
	@Test
	@DisplayName("Test for adding players")
	public void testInitPlayers() {
		
		Players players = setupGameService.initPlayers();
		
		assertNotNull(players);
		assertNotNull(players.getPlayers());
		assertEquals(2, players.getPlayers().size());
	}
}
