package com.owaiss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.owaiss.beans.ContraGme;
import com.owaiss.beans.GameConsole;
import com.owaiss.beans.GameRunner;
import com.owaiss.beans.MarioGame;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(LearnSpringApplication.class, args);
		
		GameRunner runner= context.getBean(GameRunner.class);
//		ContraGme contra=new ContraGme();
//		MarioGame game= new MarioGame();
		
//		GameConsole game=new MarioGame();
//		GameRunner runner=new GameRunner(game);
//		
		runner.run();
		
	}

}
