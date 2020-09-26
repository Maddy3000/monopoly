package com.game.monopoly.service;

import org.springframework.stereotype.Service;

import com.game.monopoly.constant.CellType;
import com.game.monopoly.exception.InsufficientFundsException;
import com.game.monopoly.model.Hotel;
import com.game.monopoly.model.Player;

@Service
public class PlayerService implements IPlayerService {

	@Override
	public void buy(Player player, Hotel hotel) {
		
		if(player.getAmount() >= CellType.H.getValue()) {
			player.setAmount(player.getAmount() - CellType.H.getValue());
			hotel.setOwner(player);
			player.getHotels().add(hotel);
		} else {
			throw new InsufficientFundsException("You don't have enough money to buy this hotel");
		}
	}

	@Override
	public void payRent(Player owner, Player tenant, int rent) {
		
		if (tenant.getAmount() >= CellType.H.getValue()) {
			tenant.setAmount(tenant.getAmount() - rent);
			owner.setAmount(owner.getAmount() + rent);
		} else {
			throw new InsufficientFundsException("You don't have enough money to pay rent");
		}
	}

}
