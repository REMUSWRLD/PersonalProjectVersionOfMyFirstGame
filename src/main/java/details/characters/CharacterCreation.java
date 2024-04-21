package details.characters;


import daos.ClassesDAO;
import daos.DaoException;
import daos.PlayerDAO;
import models.Player;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class CharacterCreation {



    ////////INITAL DATABASE CONNECTION/////////////
    public static Character playerOne = null;
    public static Character opponent = null;
    public static void player(PlayerDAO playerDAO, ClassesDAO classesDAO) throws DaoException {
        //TEMP VALUES TO INSERT PLAYER INFO INTO DATABASE
        int Account_ClassId = 0;
        String Account_Name = null;
        int Account_Level = 0;
        /////////////////////////////////////////////////

        int score = 0;
        System.out.println("Welcome! Please Choose a class!");
        String[] Characters = {"Knight", "Wizard", "Thief"};
        for (int i = 0; i < Characters.length; i++) {
            System.out.println((i + 1) + ": " + Characters[i]);
        }
        Scanner scanner = new Scanner(System.in);
        //FIRST CHOICE OF CLASS
    boolean validCharacterSelection = false;
        while(!validCharacterSelection) {
        String selection = scanner.nextLine();

        switch (selection) {
            case "1":
                playerOne = new Knight(100);
                Account_ClassId = 1;
                validCharacterSelection = true;
                break;
            case "2":
                playerOne = new Wizard(100);
                Account_ClassId = 2;
                validCharacterSelection = true;
                break;
            case "3":
                playerOne = new Thief(100);
                Account_ClassId = 3;
                validCharacterSelection = true;
                break;

            default: System.out.println("Please type a number between 1 and 3");
        }
    }

    //NAMING THE CHARACTER
        System.out.println("Did you want to name your " + playerOne.getCharacterClass() + "? ");

    //FIRST LOOP AROUND PROMPT IF THE USER WANTS TO NAME YOUR CHARACTER
    String willName = null;
    boolean validWillNameSelection = false;
        while(!validWillNameSelection) {
        willName = scanner.nextLine();
        if (willName.equalsIgnoreCase("y") || willName.equalsIgnoreCase("yes") || willName.equalsIgnoreCase("n") || willName.equalsIgnoreCase("no")) {
            validWillNameSelection = true;
        } else {
            validWillNameSelection = false;
            System.out.println("Please type 'yes/y' or 'no/n'");
        }
    }

    //SECOND LOOP AROUND IF THE NAME SELECTION IS CORRECT
    String name = null;
    boolean areYouSure = false;
    boolean correctName = false;
        if(willName.equalsIgnoreCase("y") || willName.equalsIgnoreCase("yes")) {
        while (!areYouSure &&!correctName) {
            System.out.println("What would you like your " + playerOne.getCharacterClass() + "'s name to be? ");
            String tempName = scanner.nextLine();


            System.out.println("Your " + playerOne.getCharacterClass() + "'s name will be " + tempName + " is this correct?");
            String nameConfirmation = null;
            boolean validCorrectNameSelection = false;

            //CHECKING IF THE INPUT FOR (is this correct) IS EITHER Y or YES or N or NO
            while (!validCorrectNameSelection) {
                nameConfirmation = scanner.nextLine();
                if (nameConfirmation.equalsIgnoreCase("y") || nameConfirmation.equalsIgnoreCase("yes") || nameConfirmation.equalsIgnoreCase("n") || nameConfirmation.equalsIgnoreCase("no")) {
                    validCorrectNameSelection = true;
                    Account_Name = tempName;
                } else {
                    System.out.println("Please type 'yes/y' or 'no/n'");
                }
            }

            //IF THE USER WANTS TO NAME THE CHARACTER AND THE NAME THEY INPUTTED IS CORRECT THEN SET EVERYTHING AND PRINT
            if (nameConfirmation.equalsIgnoreCase("y") || nameConfirmation.equalsIgnoreCase("yes")) {
                name = tempName;
                playerOne.setName(name);
                areYouSure = true;
                correctName = true;
                System.out.println();
                System.out.println("Player one: " + playerOne.getName());
                System.out.println(playerOne);
            }
        }
        }

    //IF THE USER INPUTS (n or no) THEN PRINT THE PLAYER ONE WITH NO NAME
        if(willName.equalsIgnoreCase("n") || willName.equalsIgnoreCase("no")) {
            Account_Name = null;
            System.out.println();
            System.out.println("Player one: " + playerOne.getName());
            System.out.println(playerOne);
        }
        //ADDMING EVERYTHING TO THE DATABASE

        // Insert the new player into the database
        Player playerId = playerDAO.createPlayer(Account_Name, Account_ClassId, Account_Level);
    }


    //OPPENET CREATION
    public static void opponent () {
        int score = 0;
        String[] Characters = {"Knight", "Wizard", "Thief"};
        for (int i = 0; i < Characters.length; i++) {
            System.out.println((i + 1) + ": " + Characters[i]);
        }
        Scanner scanner = new Scanner(System.in);
        //SELECTING THE CHARACTER NO TXT FILE
        boolean validCharacterSelection = false;
        while(!validCharacterSelection) {
            String selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    opponent = new Knight(100);
                    validCharacterSelection = true;
                    break;
                case "2":
                    opponent = new Wizard(100);
                    validCharacterSelection = true;
                    break;
                case "3":
                    opponent = new Thief(100);
                    validCharacterSelection = true;
                    break;
                default: System.out.println("Please type a number between 1 and 3");
            }
        }
        System.out.println();
        System.out.println("Opponent: " + opponent.toString());
    }
}
