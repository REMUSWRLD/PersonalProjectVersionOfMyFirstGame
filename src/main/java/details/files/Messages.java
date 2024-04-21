package details.files;

import daos.ClassesDAO;
import daos.DaoException;
import daos.PlayerDAO;
import details.characters.CharacterCreation;
import models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Messages {
static Scanner scanner = new Scanner(System.in);
    public static void introduction2(PlayerDAO playerDAO, ClassesDAO classesDAO) throws DaoException {
        boolean firstSelection = false;

            System.out.println("WELCOME!");

        while (!firstSelection) {
            String[] Characters = {"Create New Character", "Select Previous Character", "Quit"};
            for (int i = 0; i < Characters.length; i++) {
                System.out.println((i + 1) + ": " + Characters[i]);
            }

            String selection = scanner.nextLine();
            boolean secondSelection = false;
                switch (selection) {
                case "1":
                        System.out.println("Are you sure you would like to create a new character? ");
                        while(!secondSelection) {
                                String confirmation = scanner.nextLine();
                                switch (confirmation) {
                                    case "yes":
                                    case "y":
                                        CharacterCreation.player(playerDAO, classesDAO);
                                        secondSelection = true;
                                        firstSelection = true;
                                        break;
                                    case "no":
                                    case "n":
                                        System.out.println("Please select an option: ");
                                        secondSelection = true;
                                        break;
                                    default:
                                        System.out.println("Please type 'yes/y' or 'no/n'");
                                        break;
                                }
                            }
                        break;

                case "2":
                    System.out.println("Please select the ID associated with your character or type 'go back': ");
                    playerDAO.listEachPlayers(playerDAO.getAllPlayers());
                    System.out.println("- Go back");
                    boolean tempLoopSelection = false; //SORRY I AM TERRIBLE AT VARIABLE NAMES
                    while(!tempLoopSelection) {
                    String selectPreviousCharacterOption = scanner.nextLine();

                        if (selectPreviousCharacterOption.matches("\\d+")) { //Had to look this up lol but it allows to see if the input is any number, \d+
                            int characterId = Integer.parseInt(selectPreviousCharacterOption);
                            Player selectedPlayer = playerDAO.getPlayerById(characterId);

                            if (selectedPlayer != null) { //So a character was found
                                System.out.println("Character selected: " + selectedPlayer.getName());
                                boolean fightOrEditSelection = false;
                                while(!fightOrEditSelection) {
                                    System.out.println("1. Fight! (CURRENTLY DOES NOT WORK WITH AN OLD CHARACTER WILL FIX ASAP)");
                                    System.out.println("2. Edit your character's name: ");
                                    System.out.println("3. Delete Character: ");
                                    System.out.println("3. Quit: ");
                                    String fightOrEdit = scanner.nextLine();
                                    switch (fightOrEdit) {
                                        case "1":
                                            firstSelection = true;
                                            fightOrEditSelection = true;
                                            tempLoopSelection = true;
                                            break;

                                            case "2":
                                                System.out.println("Please enter your new name: ");
                                                String newName = scanner.nextLine();
                                                playerDAO.updatePlayerName(newName, Integer.parseInt(selectPreviousCharacterOption));
                                                firstSelection = true;
                                                tempLoopSelection = true;
                                                fightOrEditSelection = true;
                                                break;
                                            case "3":
                                                System.out.println("Are you sure you would like to delete this character? ");
                                                while(!secondSelection) {
                                                        String confirmation = scanner.nextLine();
                                                        switch (confirmation) {
                                                            case "yes":
                                                            case "y":
                                                                System.out.println("Deleting Character... ");
                                                                System.out.println("Please select an option: ");
                                                                playerDAO.deletePlayerById(Integer.parseInt(selectPreviousCharacterOption));
                                                                secondSelection = true;
                                                                tempLoopSelection = true;
                                                                fightOrEditSelection = true;
                                                                break;
                                                            case "no":
                                                            case "n":
                                                                System.out.println("Please select an option: ");
                                                                secondSelection = true;
                                                                break;
                                                            default:
                                                                System.out.println("Please type 'yes/y' or 'no/n'");
                                                                break;
                                                        }
                                                    }
                                                break;

                                            case "4":
                                                System.out.println("Bye bye! See you soon ;)");
                                                System.exit(0);
                                                break;

                                            default:
                                                System.out.println("Please enter a number between 1 & 3!");
                                    }
                                }
                            } else {
                                System.out.println("Character not found. Please try again.");
                            }
                        } else if (selectPreviousCharacterOption.equalsIgnoreCase("go back")) {
                            System.out.println("Going back...");
                            tempLoopSelection = true;
                        } else {
                            System.out.println("Please select one of the character IDs or type 'go back'. ");
                        }
                    }
                    break;

                case "3":
                    System.out.println("Bye bye! See you soon ;)");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter a number between 1 & 3!");
            }
        }
    }

    public static String introduction(){
        return "CHOOSE YOUR CHARACTER !";
    }
    public static String opponent(){
        return System.lineSeparator()+"Choose your opponent!";
    }
    public static String newRound(){
        return "Round: ";
    }
    public static String gameWon(){
        return null;
    }
    public static String gameOver(){
        return null;
    }
}
