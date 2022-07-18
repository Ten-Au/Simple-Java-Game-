package Information_and_Main;

import Grid.Grid;

import java.util.Random;

public class Data {
    protected int health = 100;
    protected int maxHealth = 100;
    protected int energy = 100;
    protected int maxEnergy = 100;
    protected String name = "You";
    protected int reichsmark = 5;
    protected String firearm = "Rifle MP-40";
    protected int ammo = 35;
    protected int firearm_damage = 45;
    protected String coldsteel = "Katana";
    protected int coldsteel_damage = 40;
    protected int playerX = 5;
    protected int playerY = 5;
    protected String food = "Pierogi";
    protected int numOfFood = 4;
    protected int foodBoostsEnergy = 50;
    protected int foodBoostsHealth = 50;
    protected int experience = 0;
    protected int javaknowledge = 0;



    public String toString() {
        return "\n" + name + ": " +
                "\n\tHealth: " + health + "/" + maxHealth + "\n\tEnergy: " + energy + "/" + maxEnergy +
                "\n\tMoney: " + reichsmark +
                "\n\tFirearm: " + firearm + " with " + firearm_damage + " damage" + "\n\tAmmo: " + ammo + " shots" +
                "\n\tCold Steel: " + coldsteel + " with " + coldsteel_damage + " damage" +
                "\n\tFood: " + food + "\n\tAmount of food: " + numOfFood +
                "\n\tExperience: " + experience +
                "\n\tJava knowledge: " + javaknowledge;
    }
    public int getFoodBoostsHealth() {
        return foodBoostsHealth;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReichsmark() {
        return reichsmark;
    }

    public void setReichsmark(int money) {
        this.reichsmark = money;
    }

    public void setFirearm(String firearm) {
        this.firearm = firearm;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getFirearm_damage() {
        return firearm_damage;
    }

    public void setFirearm_damage(int firearm_damage) {
        this.firearm_damage = firearm_damage;
    }

    public String getColdsteel() {
        return coldsteel;
    }

    public int getColdsteel_damage() {
        return coldsteel_damage;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public String getFood() {
        return food;
    }

    public int getNumOfFood() {
        return numOfFood;
    }

    public void setNumOfFood(int numOfFood) {
        this.numOfFood = numOfFood;
    }

    public int getFoodBoostsEnergy() {
        return foodBoostsEnergy;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getJava() {
        return javaknowledge;
    }

    public void setJava(int javaknowledge) {
        this.javaknowledge = javaknowledge;
    }

    public void playerLost() {
        System.out.println("You are dead!");
        System.out.println(toString());
        System.exit(0);
    }
    public void PlayerLocation(Grid grid) {
        Random rand = new Random();
        playerX = rand.nextInt(grid.getGridX());
        playerY = rand.nextInt(grid.getGridY());
    }


}
