package com.game.monopoly;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.game.monopoly.constant.CellType;

@Configuration
public class ConstantConfig {
	
	@Bean
	public CellType init() {
		return CellType.E;
	}
}
