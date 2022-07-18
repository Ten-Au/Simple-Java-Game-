package NPC;
import Information_and_Main.Data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hitler {
    public int Hitler_health = 1000;
    public int Hitler_damage = 50;

    public String getHitler_Name() {
        return "Hitler";
    }

    @Override
    public String toString() {
        return "\n" + getHitler_Name() + ": " +
                "\n\tHealth: " + getHitler_health() +
                "\n\tDamage: " + getHitler_damage();
    }

    public int getHitler_damage() {
        return Hitler_damage;
    }


    public int getHitler_health() {
        return Hitler_health;
    }

    public void setHitler_health(int hitler_health) {
        Hitler_health = hitler_health;
    }

    public String getHitler_says() {
        return "YOU WILL DIE!";
    }
    public void HitlerAttacks(Data you) {
        if(Hitler_health > 0) {
            System.out.println("\t\nYou have been attacked by " + getHitler_Name() + "!");
            you.setHealth(you.getHealth() - getHitler_damage());
            if(you.getHealth() <= 0) {
                System.out.println("\t\n" + getHitler_Name() + " makes a final hit!");
                you.playerLost();
            }
        }
        else if(you.getHealth() < 0) {
            System.out.println("\t\n" + getHitler_Name() + " makes a final hit!");
            you.playerLost();
        }
        else if(Hitler_health <= 0)
            System.out.println("\t\n" + getHitler_Name() + " was defeated.");
    }
    public void BossFight(Data you) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nYou have summoned " + getHitler_Name() + "!");
        System.out.println(getHitler_Name() + ": " + getHitler_says());
        while (you.getHealth() > 0 && getHitler_health() > 0) {
            System.out.println(toString());
            System.out.println(you.toString());
            System.out.println("Actions: " +
                    "\n\tShoot - a" + " (Energy -10, Ammo -5, Damage +" + you.getFirearm_damage() + ")" +
                    "\n\tHit - d" + " (Energy -15, Damage +" + you.getColdsteel_damage() + ")" +
                    "\n\tShoot and Hit - z" + " (Energy -25, Ammo -5, Damage +" + (you.getColdsteel_damage() + you.getFirearm_damage()) + ")" +
                    "\n\tEat - w" + " (Energy +25, Health +25, Amount of food -1)" +
                    "\n\tUse Java skills - j" + " (Java skills -20)");
            try {
                String fight_action = scan.next();
                switch (fight_action) {
                    case "a" -> Shoot(you);
                    case "d" -> Hit(you);
                    case "z" -> ShootAndHit(you);
                    case "w" -> Eat(you);
                    case "j" -> Java(you);
                }

            } catch (InputMismatchException e) {
                System.out.println("Inappropriate letter.");
                BossFight(you);
            }
            HitlerAttacks(you);

        }
    }
    public void Shoot(Data you) {
        int energy = you.getEnergy();
        int ammo = you.getAmmo();
        if(you.getAmmo() >= 5 && you.getEnergy() >= 10) {
            System.out.println("You made some holes in " + getHitler_Name() + "!");
            setHitler_health(Hitler_health -= you.getFirearm_damage());
            you.setEnergy(energy - 10);
            you.setAmmo(ammo - 5);

        }
        else if(you.getAmmo() < 5)
            System.out.println("Not enough ammo!!!");
        else if(you.getEnergy() < 10)
            System.out.println("Energy is below ur abilities...");
    }
    public void Hit(Data you) {
        int energy = you.getEnergy();
        if(you.getEnergy() >=15) {
            System.out.println("Oh yeah, almost in half! Get that, " + getHitler_Name());
            setHitler_health(Hitler_health -= you.getColdsteel_damage());
            you.setEnergy(energy - 15);

        }
        else if(you.getEnergy() < 15)
            System.out.println("You are too weak to use " + you.getColdsteel());
    }
    public void ShootAndHit(Data you) {
        int energy = you.getEnergy();
        int ammo = you.getAmmo();
        if(you.getEnergy() >= 25 && you.getAmmo() >= 5) {
            System.out.println("Woow! Impressive!");
            setHitler_health(Hitler_health -= (you.getFirearm_damage() + you.getColdsteel_damage()));
            you.setEnergy(energy - 10);
            you.setAmmo(ammo - 5);

        }
        else if (you.getEnergy() < 25)
            System.out.println("You don't have much energy... try to eat Pierogi");
        else if (you.getAmmo() < 5) {
            System.out.println("No ammo for today! But at least you hit him!");
            setHitler_health(Hitler_health -= you.getFirearm_damage());
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
        else if(you.getHealth() >= you.getMaxHealth()) {
            System.out.println("You are healthy!");
        }
        else if(you.getEnergy() >= you.getMaxEnergy()) {
            System.out.println("You are strong!");
        }
        else if(you.getNumOfFood() < 1)
            System.out.println("No " + you.getFood() + "'s :(");

    }
    public void Java(Data you) {
        Scanner next = new Scanner(System.in);
        String anything;
        if(you.getJava() >= 20) {
            System.out.println("\nYou took your laptop and started to write a code..." + "\n (Type anything to continue)");
            anything = next.next();
            System.out.println("\nHitler looked at you as if you were almost dead..." + "\n (Type anything to continue)");
            anything = next.next();
            System.out.println("\nA little smile on your face appeared. You almost finished with your code." + "\n (Type anything to continue)");
            anything = next.next();
            System.out.println("\n'What are you doing?' - asked Hitler, watching at you" + "\n (Type anything to continue)");
            anything = next.next();
            System.out.println("\n'Nothing... just making sure it works' - said you, pressing enter - 'Hello from PJATK!'" + "\n (Type anything to continue)");
            anything = next.next();
            System.out.println("\nHitler disappeared. You have won!");
            System.exit(0);
        }
        else
            System.out.println("You are not skilled in Java. Sorry ;(");
    }



}
