//Program: Custom RPS Game
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program simulates a rock-paper-scissors game using Swords, Spears, and Axes. Swords beat Axes, Spears beat Swords, Axes beat Spears.
//The program asks a user to input their name and their choice of weapon. Then, the computer randomly chooses between the weapons.
//The weapons are compared to each other and the winner is declared. Similar weapons result in a tie. 
//This file is the Main program file.

import java.util.Scanner;
import java.util.Random;

public class Main {
    //This is the global section. All variables and constants declared here can be seen and used by the entire program.
    //Do not declare variables and constants in this section.

    public static void main(String[] args) {
        ////Declarations////

        //Strings
        String name;
        String weapon = "";
        String comWeapon;

        //Objects
        Scanner inputDevice = new Scanner(System.in);
        Game player = new Game();  //This is an object of your Game class, DO NOT create more objects of the Game class.


        //Write the code for main that will ask the user for the name and set it in the class using the object "player" below.
        System.out.println("");
        System.out.println("The game has begun.");
        System.out.println("");

        System.out.print("What is your name? >>");
        name = inputDevice.nextLine();
        player.setName(name);

        //Then call the function "chooseWeapon" which will print a menu for user to choose a weapon from.
        do {
            weapon = chooseWeapon();
        } while (weapon == "");
        
        //Then call the function "getCompWeapon" which will randomly assign a weapon to the computer.
        comWeapon = getComWeapon();

        //Then call the "testWinner" function from the Game class to see who won and why.
        player.testWinner(weapon, comWeapon);
    }

    public static String chooseWeapon() {
        //This function will print a menu of weapons for the player to choose from.
        int choiceInt;
        String choiceString = "";
        Scanner inputDevice = new Scanner(System.in);

        System.out.println("");
        System.out.println("Weapon List:");
        System.out.println("");
        System.out.println("1. Sword");
        System.out.println("2. Spear");
        System.out.println("3. Axe");
        System.out.println("");

        //It will then take the integer input by the user and convert it into a string weapon.
        System.out.print("Choose your weapon: (1-3) >>");
        choiceInt = inputDevice.nextInt();

        switch (choiceInt) {
            case 1: choiceString = "Sword"; break;
            case 2: choiceString = "Spear"; break;
            case 3: choiceString = "Axe"; break;
            default: System.out.println(""); System.out.println("Invalid selection. Please select a number from 1-3.");
        }

        //It will then return the string weapon to main.
        return choiceString;
    }

    public static String getComWeapon() {
        //This function will generate a random number to choose a weapon for the computer.
        int randNum = 0;
        String comString = "";
        Random random = new Random();

        do {
            randNum = random.nextInt(4);
        } while (randNum == 0);

        //It will then convert the random number into a string weapon.
        switch (randNum) {
            case 1: comString = "Sword"; break;
            case 2: comString = "Spear"; break;
            case 3: comString = "Axe";
        }

        //It will return the string weapon to main.
        return comString;
    }
}