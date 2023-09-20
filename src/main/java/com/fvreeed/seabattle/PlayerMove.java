package com.fvreeed.seabattle;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerMove {

    Scanner scanner = new Scanner(System.in);

    GameBoard gameBoard = new GameBoard();

    Sea computerSea = new Sea();

    ArrayList<String> playerMoves = new ArrayList<>();

    public void move(Sea sea, Computer computer) {
        System.out.println("\n-------ENEMY SEA-------");
        gameBoard.drawBoard(computerSea);
        int[] coordinates = playerInput();
        int x = coordinates[0];
        int y = coordinates[1];

        if (sea.seaZone[x][y] == '+') {
            sea.seaZone[x][y] = 'X';
            computerSea.seaZone[x][y] = 'X';
            computer.setHealth(computer.getHealth() - 1);
            if (computer.getHealth() > 0)
                move(sea, computer);
        } else {
            sea.seaZone[x][y] = 'O';
            computerSea.seaZone[x][y] = 'O';
        }
        gameBoard.drawBoard(computerSea);
    }

    private int[] playerInput() {

        String userInput;

        System.out.println("Enter coordinates.");

        do {
            userInput = scanner.nextLine();

            if (userInput.equals("\\quit")) {
                System.exit(0);
            }
        } while (!checkInput(userInput));

        return coordinates(userInput);
    }

    private boolean checkInput(String input) {

        boolean isValid = true;

        if (input.length() > 4 || input.length() < 3) {
            System.out.println("Invalid input. Re-enter the coordinates.");
            return false;
        }

        String[] checkCoordinates = input.split(",");

        if (checkCoordinates.length == 2) {

            char[] firstCoordinate = checkCoordinates[0].toCharArray();
            char[] secondCoordinate = checkCoordinates[1].toCharArray();

            if (firstCoordinate.length != 1)
                isValid = false;
            if ((int) firstCoordinate[0] > 74 || (int) firstCoordinate[0] < 65)
                isValid = false;
            if (secondCoordinate.length > 2 || secondCoordinate.length < 1)
                isValid = false;
            if ((int) secondCoordinate[0] > 57 || (int) secondCoordinate[0] < 49)
                isValid = false;
            if (secondCoordinate.length > 1) {
                if ((int) secondCoordinate[1] != 48) {
                    isValid = false;
                }
            }
        } else {
            isValid = false;
        }
        if (isValid && playerMoves.contains(input)) {
            System.out.println("You have already attacked here.");
            return false;
        } else {
            playerMoves.add(input);
        }
        if (!isValid)
            System.out.println("Invalid input. Re-enter the coordinates.");
        return isValid;
    }

    private int[] coordinates(String input) {

        int[] coordinates = new int[2];

        String[] coordInWord = input.split(",");

        coordinates[0] = (int) coordInWord[0].toCharArray()[0] - 65;
        coordinates[1] = Integer.parseInt(coordInWord[1]) - 1;

        return coordinates;
    }
}
