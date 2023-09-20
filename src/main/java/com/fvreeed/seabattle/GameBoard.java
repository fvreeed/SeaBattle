package com.fvreeed.seabattle;

public class GameBoard {

    private final String[] boardHead = {"  ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    private final String[] boardLeft = {"1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10"};

    public void drawBoard(Sea sea) {

        char[][] seaZone= sea.seaZone;

        // Draw upper board
        for (String s : boardHead) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Draw sea
        for (int y = 0; y < seaZone.length; y++) {
            // Draw left board
            System.out.print(boardLeft[y] + " ");
            for (char[] chars : seaZone) {
                System.out.print(chars[y] + " ");
            }
            System.out.println("|");
        }
    }
}
