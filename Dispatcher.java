package com.company;

import java.util.*;

public class Dispatcher {

    public static void main(String[] args) {
        String choose = Controller.chooseXorO();
        new TicTacToe().fillBoard();

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        new TicTacToe().printBoard();

        System.out.println(choose + " will play first. Enter a slot number to place "+choose+" in:");

        String winner = Controller.getWinner();

        Controller.gameResult(winner);
    }
}