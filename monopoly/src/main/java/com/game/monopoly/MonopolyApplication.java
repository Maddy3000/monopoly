package com.game.monopoly;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import com.game.monopoly.config.MonopolyPorperties;

@SpringBootApplication
@EnableConfigurationProperties(MonopolyPorperties.class)
public class MonopolyApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(MonopolyApplication.class)
			.bannerMode(Banner.Mode.OFF)
			.web(WebApplicationType.NONE)
			.run(args);
		
		SpringApplication.exit(context, () -> 0);
	}

}
