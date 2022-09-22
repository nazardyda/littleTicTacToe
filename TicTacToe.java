package com.company;

import java.util.ArrayList;
import java.util.List;

class TicTacToe implements ITicTacToe{
    private static List<String> board = new ArrayList<>();
    private static String turn;

    public static List<String> getBoard() {
        return board;
    }

    public static String getTurn() {
        return turn;
    }

    public static void setTurn(String turn) {
        TicTacToe.turn = turn;
    }

    // CheckWinner method will
    // decide the combination
    // of three box given below.

    @Override
    public String checkWinner()
    {
        String line = null;
        for (int a = 0; a < 8; a++) {
            switch (a) {
                case 0:
                    line = board.get(0) + board.get(1) + board.get(2);
                    break;
                case 1:
                    line = board.get(3) + board.get(4) + board.get(5);
                    break;
                case 2:
                    line = board.get(6) + board.get(7) + board.get(8);
                    break;
                case 3:
                    line = board.get(0) + board.get(3) + board.get(6);
                    break;
                case 4:
                    line = board.get(1) + board.get(4) + board.get(7);
                    break;
                case 5:
                    line = board.get(2) + board.get(5) + board.get(8);
                    break;
                case 6:
                    line = board.get(0) + board.get(4) + board.get(8);
                    break;
                case 7:
                    line = board.get(2) + board.get(4) + board.get(6);
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (board.contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }

    // To print out the board.
    /* |---|---|---|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |---|---|---|*/
    @Override
    public void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board.get(0) + " | " + board.get(1)+ " | " + board.get(2) + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " |");
        System.out.println("|---|---|---|");
    }
    @Override
    public void fillBoard() {
        for (int a = 0; a < 9; a++) {
            board.add(String.valueOf(a+1));
        }
    }
}
