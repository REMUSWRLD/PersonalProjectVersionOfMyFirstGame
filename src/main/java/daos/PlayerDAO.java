package daos;

import models.Player;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    //INITIALIZING DATABASE BEFORE PASSING IT
    private JdbcTemplate jdbcTemplate;
    //PASSING SPECIFIC DATASOURCE INTO THE FOLLOWING PROGRAM
    public PlayerDAO(BasicDataSource basicDataSource) {
       jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

    public Player getPlayer_ByName(String name) {
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT * FROM player WHERE name = ?", name);
        if (rowSet.next()) {
            return mapRowToPlayer(rowSet);
        }
        return null;
    }
    //Method wont work if multiple players have the same name, need to figure something else out

    public Player getPlayerById(int playerId) {
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT * FROM player WHERE player_id =?", playerId);
        if(rowSet.next()) {
            return mapRowToPlayer(rowSet);
        }
        return null;
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<Player>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT * FROM player");
        while(rowSet.next()) {
            Player player = mapRowToPlayer(rowSet);
            players.add(player);
        }
        return players;
    }

    public void listEachPlayers(List<Player> players) {
        for (Player currentPlayer : players) {
            System.out.print("ID: " + currentPlayer.getCharacter_id() + " Name: " +  currentPlayer.getName());
            System.out.println();
        }
    }

    //INSERT NEW PLAYER INFO CHARACTER_ID NAME CLASS LEVEL
    public Player createPlayer(String name, int class_id, int level) throws DaoException {
        Player newPlayer = null;
        String sql = "INSERT INTO PLAYER (name, class_id, level) VALUES (?, ?, ?) RETURNING player_id;";

        try {
            int newPlayerId = jdbcTemplate.queryForObject(sql, Integer.class, name, class_id, level);
            newPlayer = getPlayerById(newPlayerId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation");
        }
        return newPlayer;
    }


    //Update name of a player
    public Player updatePlayerName(String name, int player_id) throws DaoException {
        Player updatedPlayer = null;
        String sql = "UPDATE player SET name =? WHERE player_id =?";

        try {
            jdbcTemplate.update(sql, name, player_id);
            updatedPlayer = getPlayerById(player_id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation");
        }
        return updatedPlayer;
    }

    public int deletePlayerById(int player_id) throws DaoException {
        String sql = "DELETE FROM player WHERE player_id =?";
        int deletedPlayer;
        try {
            deletedPlayer = jdbcTemplate.update(sql, player_id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation");
        }
        return deletedPlayer;
    }
    //MAP ROW FUNCTION TO PULL PLAYER AND CORRESPONDING ATTRIBUTES
    public Player mapRowToPlayer(SqlRowSet row) {
        Player player = new Player();
        player.setCharacter_id(row.getInt("player_id"));
        player.setName(row.getString("name"));
        player.setCharacter_Class("class_id");
        player.setLevel(row.getInt("level"));
        return player;
    }
}
