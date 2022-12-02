package com.owaiss.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	//private MarioGame game;

	
	private GameConsole game;
	
	@Autowired
	public GameRunner(GameConsole game) {
		
		this.game = game;
	}

	public void run() {
		System.out.println("running..");
		game.up();
		game.jump();
		game.down();
		game.left();
		game.right();
		
	}
	
	
}
