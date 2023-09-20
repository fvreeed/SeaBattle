package com.fvreeed.seabattle;

import java.util.Random;

public class RandomShip {

    private final int[] ships = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

    private final Random random = new Random();

    public Sea setShips(Sea sea) {
        for (int i : ships) {
            addShip(sea, i);
        }
        return sea;
    }

    private void addShip(Sea sea, int length) {
        int[] coordinate = shipCoordinate();
        int orientation = random.nextInt(2);

        if (orientation == 0) {
            while (!seaCheckHorizontal(sea, coordinate, length)) {
                coordinate = shipCoordinate();
            }
            int x = coordinate[0];
            int y = coordinate[1];
            for (int i = 0; i < length; i++) {
                sea.seaZone[x][y] = '+';
                x++;
            }
        } else {
            while (!seaCheckVertical(sea, coordinate, length)) {
                coordinate = shipCoordinate();
            }
            int x = coordinate[0];
            int y = coordinate[1];
            for (int i = 0; i < length; i++) {
                sea.seaZone[x][y] = '+';
                y++;
            }
        }
    }

    private int[] shipCoordinate() {
        int[] coordinates = new int[2];
        coordinates[0] =  random.nextInt(10);
        coordinates[1] = random.nextInt(10);
        return coordinates;
    }

    private boolean seaCheckHorizontal(Sea sea, int[] coordinates, int length) {
        boolean shipCoordinates = true;
        int x = coordinates[0];
        int y = coordinates[1];
        if (x + length > 9) {
            return false;
        }
        int leftX = x == 0 ? 0 : x - 1;
        int rightX = x == 9 ? 9 : x + length;
        int upperY = y == 0 ? 0 : y - 1;
        int lowerY = y == 9 ? 9 : y + 1;
        for (int i = upperY; i <= lowerY; i++) {
            for (int j = leftX; j <= rightX; j++) {
                if (sea.seaZone[j][i] == '+') {
                    shipCoordinates = false;
                    break;
                }
            }
        }
        return shipCoordinates;
    }

    private boolean seaCheckVertical(Sea sea, int[] coordinates, int length) {
        boolean shipCoordinates = true;
        int x = coordinates[0];
        int y = coordinates[1];
        if (y + length > 9) {
            return false;
        }
        int upperY = y == 0 ? 0 : y - 1;
        int lowerY = y == 9 ? 9 : y + length;
        int leftX = x == 0 ? 0 : x - 1;
        int rightX = x == 9 ? 9 : x + 1;
        for (int j = leftX; j <= rightX; j++) {
            for (int i = upperY; i <= lowerY; i++) {
                if (sea.seaZone[j][i] == '+') {
                    shipCoordinates = false;
                    break;
                }
            }
        }
        return shipCoordinates;
    }
}
