package A;

import daos.ClassesDAO;
import daos.DaoException;
import daos.PlayerDAO;
import details.Rounds;
import details.characters.CharacterCreation;
import details.files.Messages;
import models.Player;
import org.apache.commons.dbcp2.BasicDataSource;

public class Game {

    public static void main(String[] args) throws DaoException {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:postgresql://localhost:5432/Game");
        basicDataSource.setUsername("postgres");
        basicDataSource.setPassword("postgres1");

        PlayerDAO playerDAO = new PlayerDAO(basicDataSource);
        ClassesDAO classesDAO = new ClassesDAO(basicDataSource);

        Messages.introduction2(playerDAO, classesDAO);

        System.out.println(Messages.opponent());

        CharacterCreation.opponent();

        //Rounds.newRound();
    }
}