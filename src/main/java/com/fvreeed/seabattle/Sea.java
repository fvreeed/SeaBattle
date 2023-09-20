package com.fvreeed.seabattle;

public class Sea {

    private final int WIDTH = 10;

    private final int HEIGHT = 10;

    public final char[][] seaZone = new char[WIDTH][HEIGHT];

    public void getSeaZone() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                seaZone[x][y] = ' ';
            }
        }
    }
}
