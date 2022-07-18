package Information_and_Main;
import Actions.Actions;
import Mobs.Mobs;
import Grid.Grid;
import java.util.Scanner;
import NPC.Hitler;
import NPC.Java;
import Mobs.Sturmmann;
import Mobs.Obersturmfuhrer;
import Mobs.Schwerer_Hund;
import Mobs.Psycho_Slasher;
import Traps.BearTrap;
import Traps.Mine;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Data you = new Data();
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        Hitler hitler = new Hitler();
        System.out.println("\n\tWelcome to the snow desert, full of Nazi's." + "\n\tAzamat sent you here to kill all Nazi scums!" +
                "\n\tYou can also meet Java Professors." +
                "\n\tTo win this game, you need to summon Hitler and kill him." +
                "\n\tEarn experience by killing enemies to summon him. Also you can get a new weapon buy buying it with money you have" +
                "\n\tRemember: Do not run!" +
                "\n\tAzamat wishes you good luck.");
        System.out.println("What is your name?");
        String name = scan.next();
        you.setName(name);
        System.out.println(you.toString());
        Actions move = new Actions();
        Grid grid = new Grid(9, 9);
        Mobs [] sturmann = new Sturmmann[rand.nextInt(13)];
        Mobs [] obersturmfuhrer = new Obersturmfuhrer[rand.nextInt(13)];
        Mobs [] scwherer_hund = new Schwerer_Hund[rand.nextInt(13)];
        Mobs [] psycho_slasher = new Psycho_Slasher[rand.nextInt(13)];
        Java [] javaprof = new Java[rand.nextInt(13)];
        Mine [] mine = new Mine[rand.nextInt(13)];
        BearTrap [] trap = new BearTrap[rand.nextInt(13)];

        play(you, grid, move, sturmann, obersturmfuhrer, scwherer_hund, psycho_slasher, hitler, javaprof, mine, trap);

    }
    public static void checkMine(Data you, Mine [] mine, Actions step) {
        if(mine != null) {
            for(int i = 0; i < mine.length; i++) {
                if(mine[i].getMineX() == you.playerX && mine[i].getMineY() == you.playerY) {
                    step.MineMeeting(you);
                }
            }
        }
    }

    public static void checkJava(Data you, Java [] javaprof, Actions learning) {
            if(javaprof != null) {
                for (int i = 0; i < javaprof.length; i++) {
                    if (javaprof[i].javaX == you.playerX && javaprof[i].javaY == you.playerY) {
                        learning.JavaProfessor(you);
                    }
                }
            }
        }
    public static void locateObjects(Grid grid, Mobs [] sturmann,Mobs [] obersturmfuhrer, Mobs [] scwherer_hund, Mobs [] psycho_slasher,Java [] javaprof, Mine [] mine) {
        for (int i = 0; i < obersturmfuhrer.length; i++) {
            obersturmfuhrer[i] = new Obersturmfuhrer();
            obersturmfuhrer[i].placeMobs(grid);
        }
        for (int i = 0; i < sturmann.length; i++) {
            sturmann[i] = new Sturmmann();
            sturmann[i].placeMobs(grid);
        }
        for (int i = 0; i < scwherer_hund.length; i++) {
            scwherer_hund[i] = new Schwerer_Hund();
            scwherer_hund[i].placeMobs(grid);
        }
        for (int i = 0; i < psycho_slasher.length; i++) {
            psycho_slasher[i] = new Psycho_Slasher();
            psycho_slasher[i].placeMobs(grid);
        }
        for(int i = 0; i < javaprof.length; i++) {
            javaprof[i] = new Java();
            javaprof[i].placeJava(grid);
        }
        for(int i = 0; i < mine.length; i++) {
            mine[i] = new Mine();
            mine[i].placeMine(grid);
        }
    }
    public static void play(Data you, Grid grid, Actions action, Mobs [] sturmann, Mobs [] obersturmfuhrer, Mobs [] scwherer_hund, Mobs [] psycho_slasher, Hitler hitler, Java [] javaprof, Mine [] mine, BearTrap [] trap) {
        Actions learning = new Actions();
        Actions step = new Actions();
        you.PlayerLocation(grid);
        locateObjects(grid, sturmann, obersturmfuhrer, scwherer_hund, psycho_slasher, javaprof, mine);
        while (you.getHealth() > 0) {
            System.out.println("\nYour coordinates are: (" + you.getPlayerX() + ";" + you.getPlayerY() + ")");
            action.PlayerMovement(grid, you, hitler);
            checkMobs(you, sturmann, obersturmfuhrer, scwherer_hund, psycho_slasher, action);
            checkJava(you, javaprof, learning);
            checkMine(you, mine, step);

        }

    }
    public static void checkMobs(Data you, Mobs[] sturmann, Mobs[] obersturmfuhrer, Mobs[] scwherer_hund, Mobs [] psycho_slasher, Actions fight) {
        for (int i = 0; i < sturmann.length; i++){
            if (sturmann[i] != null) {
                if(sturmann[i].mobX == you.playerX && sturmann[i].mobY == you.playerY) {
                    fight.Fight(you, sturmann[i]);
                }
            }
        }
        for (int i = 0; i < obersturmfuhrer.length; i++){
            if (obersturmfuhrer[i] != null) {
                if(obersturmfuhrer[i].mobX == you.playerX && obersturmfuhrer[i].mobY == you.playerY) {
                    fight.Fight(you, obersturmfuhrer[i]);
                }
            }
        }
        for (int i = 0; i < scwherer_hund.length; i++){
            if (scwherer_hund[i] != null) {
                if(scwherer_hund[i].mobX == you.playerX && scwherer_hund[i].mobY == you.playerY) {
                    fight.Fight(you, scwherer_hund[i]);
                }
            }
        }
        for (int i = 0; i < psycho_slasher.length; i++){
            if (psycho_slasher[i] != null) {
                if(psycho_slasher[i].mobX == you.playerX && psycho_slasher[i].mobY == you.playerY) {
                    fight.Fight(you, psycho_slasher[i]);
                }
            }
        }
    }





}