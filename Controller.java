package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private static final Scanner in = new Scanner(System.in);
    static String chooseXorO(){
        System.out.print("Choose X or O: ");
        String choose = in.next();
        if(choose.equalsIgnoreCase("X")){
            TicTacToe.setTurn("X");
        }else if(choose.equalsIgnoreCase("O")){
            TicTacToe.setTurn("O");
        }else{
            System.err.println("Wrong input");
            System.exit(0);
        }
        return choose;
    }
    static String getWinner() {
        String winner = null;
        while (winner == null) {
            int numInput;

            // Exception handling.
            // numInput will take input from user like from 1 to 9.
            // If it is not in range from 1 to 9.
            // then it will show you an error "Invalid input."
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input; re-enter slot number:");
                continue;
            }

            // This game has two player x and O.
            // Here is the logic to decide the turn.
            if (TicTacToe.getBoard().get(numInput - 1).equals(
                    String.valueOf(numInput))) {
                TicTacToe.getBoard().set(numInput - 1, TicTacToe.getTurn());

                if (TicTacToe.getTurn().equals("X")) {
                    TicTacToe.setTurn("O");
                }
                else if(TicTacToe.getTurn().equals("O")){
                    TicTacToe.setTurn("X");
                }

                new TicTacToe().printBoard();
                winner = new TicTacToe().checkWinner() ;
            }
            else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }
        }
        return winner;
    }
     static void gameResult(String winner) {
        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }// For winner -to display Congratulations! message.
        else {
            System.out.println(
                    "Congratulations! " + winner
                            + "'s have won! Thanks for playing.");
        }
    }
}
