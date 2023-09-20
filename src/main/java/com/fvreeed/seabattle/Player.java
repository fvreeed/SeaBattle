package com.fvreeed.seabattle;

public class Player {

    private int health = 20;

    Sea sea = new Sea();

    RandomShip randomShip = new RandomShip();

    public Sea playerSea() {
        sea = randomShip.setShips(sea);
        return sea;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
