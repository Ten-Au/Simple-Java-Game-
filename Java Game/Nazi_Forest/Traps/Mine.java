package Traps;

import Grid.Grid;

import java.util.Random;

public class Mine {
    private int mineX;
    private int mineY;
    public Mine() { }

    public int getMineX() {
        return mineX;
    }

    public int getMineY() {
        return mineY;
    }

    public int getMine_damage() {
        int mine_damage = 10;
        return mine_damage;
    }

    public void placeMine(Grid grid) {
        Random rand = new Random();
        mineX = rand.nextInt(grid.getGridX());
        mineY = rand.nextInt(grid.getGridX());

    }
}
