package NPC;

import Grid.Grid;

import java.util.Random;

public class Java {
    public int javaX;
    public int javaY;

    public void placeJava(Grid grid) {
        Random rand = new Random();
        javaX = rand.nextInt(grid.getGridX());
        javaY = rand.nextInt(grid.getGridY());
    }

}
