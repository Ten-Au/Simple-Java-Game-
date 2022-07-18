package Actions;

import java.util.InputMismatchException;
import java.util.Scanner;
import Grid.Grid;
import Information_and_Main.Data;
import Mobs.Mobs;
import NPC.Hitler;
import Traps.Mine;

public class Actions {

    public void PlayerMovement(Grid grid, Data you, Hitler Hitler) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nNext move? (Use NumLock to move)" + "\n\tNorth - 8" + "\n\tWest - 4" + "\n\tSouth - 2" + "\n\tEast - 6" + "\n\tYour information - 0" + "\n\tSummon Hitler - 10 (you need 50 or more experience to do that)" + "\n\tBuy things - 11");
        int playerMove = scan.nextInt();
        int gridX = grid.getGridX(), gridY = grid.getGridY();
        int youY = you.getPlayerY(), youX = you.getPlayerX();
        switch (playerMove) {
            case 11 -> BuyThings(you);
            case 10 -> {
                if(you.getExperience() >= 50) {
                    Hitler.BossFight(you);
                }
                else
                    System.out.println("Not enough experience. Kill more Nazi's.");

            }
            case 8 -> {
                if (youY < gridY)
                    you.setPlayerY(youY + 1);
                else
                    System.out.println("You can not go north.");
            }
            case 4 -> {
                if (youX > 1)
                    you.setPlayerX(youX - 1);
                else
                    System.out.println("You can not go west.");
            }
            case 2 -> {
                if (youY > 1)
                    you.setPlayerY(youY - 1);
                else
                    System.out.println("You can not go south.");
            }
            case 6 -> {
                if (youX < gridX)
                    you.setPlayerX(youX + 1);
                else
                    System.out.println("You can not go east.");
            }
            case 0 -> System.out.println(you.toString());
            default -> System.out.println("Inappropriate number!");
        }
    }
    public void BuyThings(Data you) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to buy? " + "\n\t1. Pierogi (Money -5, Pierogi +10)" + "\n\t2. New Rifle (Money -10, Rifle Damage +50");
        String reply = scan.next();
        switch (reply) {
            case "1" -> {
                if(you.getReichsmark() >= 5) {
                    System.out.println("You bought some Pierogi!");
                    you.setNumOfFood(you.getNumOfFood() + 10);
                    you.setReichsmark(you.getReichsmark() - 5);
                }
                else
                    System.out.println("Not enough money");
            }
            case "2" -> {
                if (you.getReichsmark() >= 10) {
                    System.out.println("You bought a new MG-42!");
                    you.setFirearm("MG-42");
                    you.setFirearm_damage(you.getFirearm_damage() + 50);
                }
                else
                    System.out.println("Not enough money");
            }
        }
    }
    public void JavaProfessor(Data you) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nYou have met Java Professor!" + "\n'Would you like to learn Java?' - asked Professor. (Energy -50)" + "\n Yes (y) / No (n)");
        String reply = scan.next();
        int java = you.getJava();
        int energy = you.getEnergy();
        switch (reply) {
            case "y" -> {
                System.out.println("\nProfessor taught you Java. Congratulations!");
                you.setJava(java + 10); you.setEnergy(energy - 50);
            }
            case "n" -> System.out.println("\nYou thanked him but refused his offer.");
        }
    }
    public void MineMeeting(Data you) {
        Mine mine = new Mine();
        System.out.println("You stepped on a mine!");
        you.setHealth(you.getHealth() - mine.getMine_damage());
    }
    public void Fight(Data you, Mobs enemy) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nYou have met " + enemy.name + "!");
        System.out.println(enemy.name + ": " + enemy.mob_says);
        while (you.getHealth() > 0 && enemy.health > 0) {
            System.out.println(enemy.toString());
            System.out.println(you.toString());
            System.out.println("\nActions: " +
                    "\n\tShoot - a" + " (Energy -10, Ammo -5, Damage +" + you.getFirearm_damage() + ")" +
                    "\n\tHit - d" + " (Energy -15, Damage +" + you.getColdsteel_damage() + ")" +
                    "\n\tShoot and Hit - z" + " (Energy -25, Ammo -5, Damage +" + (you.getColdsteel_damage() + you.getFirearm_damage()) + ")" +
                    "\n\tEat - w" + " (Energy +" + you.getFoodBoostsEnergy() + ", Health + " + you.getFoodBoostsHealth() + ", Amount of food -1)" );
            try {
                String fight_action = scan.next();
                switch (fight_action) {
                    case "a" -> Shoot(you, enemy);
                    case "d" -> Hit(you, enemy);
                    case "z" -> ShootAndHit(you, enemy);
                    case "w" -> Eat(you);
                }

            } catch (InputMismatchException e) {
                System.out.println("Inappropriate letter.");
                Fight(you, enemy);
            }
                enemy.mobAttacks(you, enemy);


        }
    }


    public void Shoot(Data you, Mobs enemy) {
        int energy = you.getEnergy();
        int ammo = you.getAmmo();
        if(you.getAmmo() >= 5 && you.getEnergy() >= 10) {
            System.out.println("You made some holes in " + enemy.getName() + "!");
            enemy.setHealth(enemy.health -= you.getFirearm_damage());
            you.setEnergy(energy - 10);
            you.setAmmo(ammo - 5);

        }
        else if(you.getAmmo() < 5)
            System.out.println("Not enough ammo!!!");
        else if(you.getEnergy() < 10)
            System.out.println("Energy is below ur abilities...");
    }
    public void Hit(Data you, Mobs enemy) {
        int energy = you.getEnergy();
        if(you.getEnergy() >=15) {
            System.out.println("Oh yeah, almost in half! Get that, " + enemy.getName());
            enemy.setHealth(enemy.health -= you.getColdsteel_damage());
            you.setEnergy(energy - 15);

        }
        else if(you.getEnergy() < 15)
            System.out.println("You are too weak to use " + you.getColdsteel());
    }
    public void ShootAndHit(Data you, Mobs enemy) {
        int energy = you.getEnergy();
        int ammo = you.getAmmo();
        if(you.getEnergy() >= 25 && you.getAmmo() >= 5) {
            System.out.println("Woow! Impressive!");
            enemy.setHealth(enemy.health -= (you.getFirearm_damage() + you.getColdsteel_damage()));
            you.setEnergy(energy - 10);
            you.setAmmo(ammo - 5);

        }
        else if (you.getEnergy() < 25)
            System.out.println("You don't have much energy... try to eat " + you.getFood());
        else if (you.getAmmo() < 5) {
            System.out.println("No ammo for today! But at least you hit him!");
            enemy.setHealth(enemy.health -= you.getFirearm_damage());
            you.setEnergy(energy - 25);

        }
    }

    public void Eat(Data you) {
        int energy = you.getEnergy();
        int health = you.getHealth();
        if(you.getNumOfFood() >= 1 && you.getEnergy() < you.getMaxEnergy() && you.getHealth() < you.getMaxHealth()) {
            System.out.println("Smacznego!");
            you.setEnergy(energy + you.getFoodBoostsEnergy());
            you.setHealth(health + you.getFoodBoostsHealth());
        }
        else if(you.getNumOfFood() < 1)
            System.out.println("No " + you.getFood() + "'s :(");

    }



}
