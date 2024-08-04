package com.priyam.learn.SpringJDBC.service;

import com.priyam.learn.SpringJDBC.model.Game;
import com.priyam.learn.SpringJDBC.repository.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private Game game;

    public void addGame(Game game) {
        System.out.println("Game is added to collection : " + game.getTitle());
        gameRepo.save(game);

    }

    public List<Game> getAllGames() {
        return gameRepo.findAll();

    }

    public void updateGame(Game game) {
        gameRepo.update(game);
    }

    public void deleteGame(Game game) {
        gameRepo.delete(game);
    }


    public GameRepo getGameRepo() {
        return gameRepo;
    }

    public void setGameRepo(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
