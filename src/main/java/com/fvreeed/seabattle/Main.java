package com.fvreeed.seabattle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("To start the game write \\start");
        String userInput = scanner.nextLine();
        if (userInput.equals("\\start")) {

            System.out.println("\nGAME RULES" +
                    "To attack, write the coordinates " +
                    "as a letter and a number, for example \"A,1\"." +
                    "To exit the game write \\exit");

            GameBoard gameBoard = new GameBoard();

            Player player = new Player();

            player.playerSea();

            System.out.println("\n--------YOUR SEA--------");

            gameBoard.drawBoard(player.sea);

            PlayerMove playerMove = new PlayerMove();

            Computer computer = new Computer();

            computer.computerSea();

            ComputerMove computerMove = new ComputerMove();

            do {
                playerMove.move(computer.sea, computer);
                computerMove.move(player.sea, player);
                System.out.println();
            } while (computer.getHealth() > 0 && player.getHealth() > 0);

            if (player.getHealth() > 0) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }
    }
}
