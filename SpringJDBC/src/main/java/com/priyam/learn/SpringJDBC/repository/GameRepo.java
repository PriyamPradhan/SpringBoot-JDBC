package com.priyam.learn.SpringJDBC.repository;

import com.priyam.learn.SpringJDBC.model.Game;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameRepo {

    private JdbcTemplate jdbc;


    public void save(Game game) {
        System.out.println("saved game : " + game.getTitle());

        String sql="insert into game (tag,title,rating) values(?,?,?)";
        int rows = jdbc.update(sql, game.getTag(), game.getTitle(), game.getRating());
        System.out.println("rows inserted: " + rows);

    }

    public void update(Game game) {
        //System.out.println("saved game : " + game.getTitle());

        String sql="update game set tag=?,title=?,rating=? where tag=?";
        int rows = jdbc.update(sql, game.getTag(), game.getTitle(), game.getRating(), game.getTag());
        System.out.println("rows updated: " + rows);

    }

    public void delete(Game game) {
        //System.out.println("saved game : " + game.getTitle());

        String sql="delete from game where tag=?";
        int rows = jdbc.update(sql, game.getTag());
        System.out.println("Game deleted : " + rows);

    }


    public List<Game> findAll(){
        String sql="select * from game";

        RowMapper<Game> rowMapper = new RowMapper<Game>() {
            @Override
            public Game mapRow(ResultSet rs, int rowNum) throws SQLException {

                Game game = new Game();
                game.setTag(rs.getInt("tag"));
                game.setTitle(rs.getString("title"));
                game.setRating(rs.getDouble("rating"));

                return game;
            }
        };

        return jdbc.query(sql, rowMapper);
    }






    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


}
