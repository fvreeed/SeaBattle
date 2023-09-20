package com.fvreeed.seabattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ComputerMove {

    Random random = new Random();

    GameBoard gameBoard = new GameBoard();

    ArrayList<String> computerMoves = new ArrayList<>();

    public void move(Sea sea, Player player) {

        int[] coordinates = randomCoordinates();

        int x = coordinates[0];
        int y = coordinates[1];

        if (sea.seaZone[x][y] == '+') {
            sea.seaZone[x][y] = 'X';
            player.setHealth(player.getHealth() - 1);
            if (player.getHealth() > 0)
                move(sea, player);
        } else {
            sea.seaZone[x][y] = 'O';
        }
        gameBoard.drawBoard(sea);
    }

    private int[] randomCoordinates() {

        int[] coordinates = new int[2];

        do {
            coordinates[0] = random.nextInt(10);
            coordinates[1] = random.nextInt(10);
        } while (!isValid(coordinates));

        return coordinates;
    }

    public boolean isValid(int[] coordinates) {
        String check = "";
        check += Arrays.toString(coordinates);
        if (computerMoves.contains(check))
            return false;
        else
            computerMoves.add(check);
        return true;
    }
}
