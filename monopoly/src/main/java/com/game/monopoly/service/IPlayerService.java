package com.game.monopoly.service;

import com.game.monopoly.model.Hotel;
import com.game.monopoly.model.Player;

public interface IPlayerService {
	
	void buy(Player player, Hotel hotel);
	void payRent(Player owner, Player tenant, int rent);
}
