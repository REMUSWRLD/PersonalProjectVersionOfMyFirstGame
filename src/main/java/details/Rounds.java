package details;

import details.characters.CharacterCreation;

import java.util.Scanner;

public class Rounds{

    public static void newRound() {
        boolean gameOver = false;
        boolean playerOneTurn = true;
        boolean opponentTurn = false;
        int playerScore = 0;
        int opponentScore = 0;
        int FINAL_TOTAL_ROUNDS = 3;
        int currentRound = 1;
        int[] rounds = new int[FINAL_TOTAL_ROUNDS];
        Scanner playerMove = new Scanner(System.in);

        while(!gameOver){
            boolean fight = true;
            if (currentRound == 3) {
                gameOver = true;
            }

            System.out.println();
            System.out.println("Round " + currentRound);
            System.out.println(CharacterCreation.playerOne.getCharacterClass() +": " + playerScore + " V.S " + CharacterCreation.opponent.getCharacterClass() + ": " + opponentScore);
            System.out.println();
            System.out.println("FIGHT!");
            System.out.println();


                while (fight) {
                    if (playerOneTurn) {
                        System.out.println("Player one's turn: " + System.lineSeparator());
                        String[] Moves = {"Attack"};
                        for (int i = 0; i < Moves.length; i++) {
                            System.out.println((i + 1) + ": " + Moves[i]);
                        }
                        int playerMoveChoice = playerMove.nextInt();

                        if (playerMoveChoice == 1) {
                            System.out.println("Player one's attacks " + CharacterCreation.opponent.getCharacterClass() + "!" + System.lineSeparator());
                            CharacterCreation.playerOne.attack(CharacterCreation.opponent);
                            System.out.println("You're opponent has " + CharacterCreation.opponent.getHealth() + " health left!" + System.lineSeparator());
                        }

                        if (CharacterCreation.opponent.getHealth() <= 0) {
                            System.out.println("You have defeated " + CharacterCreation.opponent.getCharacterClass() + "! ");
                            playerScore += 1;
                            currentRound += 1;
                            fight = false;

                        } else {
                            //MORE MOVES
                            playerOneTurn = false;
                            opponentTurn = true;
                        }
                    }


                    if (opponentTurn) {
                        System.out.println("Your opponent's turn: " + System.lineSeparator());
                        String[] Moves = {"Attack"};
                        for (int i = 0; i < Moves.length; i++) {
                            System.out.println((i + 1) + ": " + Moves[i]);
                        }
                        int opponentMoveChoice = playerMove.nextInt();

                        if (opponentMoveChoice == 1) {
                            System.out.println(CharacterCreation.opponent.getCharacterClass() + " attacks" + "!" + System.lineSeparator());
                            CharacterCreation.opponent.attack(CharacterCreation.playerOne);
                            System.out.println("You have " + CharacterCreation.playerOne.getHealth() + " health left!" + System.lineSeparator());
                        }
                        //MORE MOVES

                        if (CharacterCreation.playerOne.getHealth() <= 0) {
                            System.out.println("You have  been defeated :( ");
                            opponentScore += 1;
                            currentRound += 1;
                            fight = false;
                        } else {
                            opponentTurn = false;
                            playerOneTurn = true;
                        }
                    }

//                }

            }
        }
        System.out.println("game over!");
    }
}
