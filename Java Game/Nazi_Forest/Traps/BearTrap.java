package Traps;

import Grid.Grid;

import java.util.Random;

public class BearTrap {
    private int trapX;
    private int trapY;
    public void Trap() { }

    public int getTrapX() {
        return trapX;
    }

    public int getTrapY() {
        return trapY;
    }

    public int getTrapDamage() {
        int trap_damage = 10;
        return trap_damage;
    }

    public void placeTrap(Grid grid) {
        Random rand = new Random();
        trapX = rand.nextInt(grid.getGridX());
        trapY = rand.nextInt(grid.getGridX());

    }
}
