package daos;

import models.Classes;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class ClassesDAO {
    private JdbcTemplate jdbcTemplate;
    public ClassesDAO(BasicDataSource basicDataSource) {
        jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

    //DAO's
    public List<Classes> getListOfClasses() {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM class");
        List<Classes> classes = new ArrayList<>();
        while(sqlRowSet.next()) {
            Classes currentClass = mapRowToClasses(sqlRowSet);
            classes.add(currentClass);
        }
        return classes;
    }

    public void listEachClasses(List<Classes> classes) {
        for (Classes currentClass : classes) {
            System.out.print(currentClass.getName());
            System.out.println();
        }
        System.out.println();
    }

    //ROW-SET TO CREATE AN INSTANCE OF CLASSES
    public Classes mapRowToClasses(SqlRowSet row) {
        Classes classes = new Classes();
        classes.setClass_id(row.getInt("class_id"));
        classes.setName(row.getString("name"));
        classes.setHealth(row.getInt("health"));
        classes.setAttackPower(row.getInt("attack_power"));
        classes.setSpecialMove(row.getString("special_move"));
        return classes;
    }
}
