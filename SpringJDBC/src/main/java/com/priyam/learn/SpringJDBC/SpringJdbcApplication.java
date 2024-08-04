package com.priyam.learn.SpringJDBC;

import com.priyam.learn.SpringJDBC.model.Game;
import com.priyam.learn.SpringJDBC.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Game game = context.getBean(Game.class);
		game.setTag(7);
		game.setTitle("Call Of Duty : MW IV");
		game.setRating(8.0);
		//game.toString();
		System.out.println(game);

		Game gameUpdate = context.getBean(Game.class);
		gameUpdate.setTitle("Game for Peace");
		gameUpdate.setRating(9.4);
		gameUpdate.setTag(3);
		System.out.println(gameUpdate);

		Game gameDelete = context.getBean(Game.class);
		gameDelete.setTag(6);


		GameService gameService = context.getBean(GameService.class);
//		gameService.addGame(game);
		gameService.updateGame(gameUpdate);
		gameService.deleteGame(gameDelete);



		List<Game> games = gameService.getAllGames();
		System.out.println(games);
	}

}
