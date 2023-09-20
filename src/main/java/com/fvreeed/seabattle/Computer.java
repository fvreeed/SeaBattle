package com.fvreeed.seabattle;

public class Computer {

    private int health = 20;

    Sea sea = new Sea();

    RandomShip randomShip = new RandomShip();

    public void computerSea() {
        sea = randomShip.setShips(sea);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
