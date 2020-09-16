package com.game.monopoly.exception;

import org.springframework.stereotype.Component;

@Component
public class InsufficientFundsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InsufficientFundsException() {
		super();
	}

	public InsufficientFundsException(String msg) {
		super(msg);
	}
}
