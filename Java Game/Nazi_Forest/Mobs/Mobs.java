package Mobs;
import Grid.Grid;
import Information_and_Main.Data;

import java.util.Random;

public class Mobs {
    public String name;
    public String mob_says;
    public int mobX;
    public int mobY;
    public int mob_damage;
    public int health;



    public Mobs(String name, String mob_says, int health, int mob_damage){
        this.name = name;
        this.mob_says = mob_says;
        this.mob_damage = mob_damage;
        this.health = health;
    }
    public String toString() {
        return "\n" + name + ": " +
                "\n\tHealth: " + health +
                "\n\tDamage: " + mob_damage;
    }
    public void mobAttacks(Data you, Mobs enemy) {
        if(health > 0) {
            System.out.println("\t\nYou have been attacked by " + enemy.name + "!");
            you.setHealth(you.getHealth() - enemy.mob_damage);
            if(you.getHealth() <= 0) {
                System.out.println("\t\n" + enemy.name + " makes a final hit!");
                you.playerLost();
            }
        }
        else {
            System.out.println("\t\n" + enemy.name + " was defeated.");
            you.setExperience(you.getExperience() + 15);
            you.setReichsmark(you.getReichsmark() + 5);
            System.out.println("\t\nYou received " + you.getReichsmark() + " reichsmarks and " + you.getExperience() + " experience.");


        }
    }

    public void placeMobs(Grid grid) {
        Random rand = new Random();
        mobX = rand.nextInt(grid.getGridX());
        mobY = rand.nextInt(grid.getGridY());
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
