//Program: Custom RPS Game
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program simulates a rock-paper-scissors game using Swords, Spears, and Axes. Swords beat Axes, Spears beat Swords, Axes beat Spears.
//The program asks a user to input their name and their choice of weapon. Then, the computer randomly chooses between the weapons.
//The weapons are compared to each other and the winner is declared. Similar weapons result in a tie. 
//This file is the Game/Player class file.

public class Game {
    //Declarations go here. All variables and constants in this section should be private.
    private String name;

    //Public functions go here. Do not use the keyword static.
    public void setName(String name) {
        //This function will be used to receive the player's name from main and set it in the class.
        //This function is complete and does not need to be changed. DO NOT MODIFY!

        this.name = name;
    }

    public void testWinner(String weapon, String comWeapon) {
        //This method will receive the string weapons from main and then will test to see who won.

        //String result. Stores the message which is displayed at the outcome of the game. Tie by default.
        String strResult = "Both weapons were the same. The game was a tie.";

        //Determine results.
        if (weapon.equals("Sword")) {
            if (comWeapon.equals("Axe")) {
                strResult = (this.name + "'s sword parried the enemy's axe! " + this.name + " won!");
            } else if (comWeapon.equals("Spear")){
                strResult = (this.name + "'s sword was outreached by the enemy's spear! " + this.name + " lost...");
            }
        } else if (weapon.equals("Spear")) {
            if (comWeapon.equals("Sword")) {
                strResult = (this.name + "'s spear outreached the enemy's sword! " + this.name + " won!");
            } else if (comWeapon.equals("Axe")){
                strResult = (this.name + "'s spear was cleaved by the enemy's axe! " + this.name + " lost...");
            }
        } else {
            if (comWeapon.equals("Spear")) {
                strResult = (this.name + "'s axe cleaved the enemy's spear! " + this.name + " won!");
            } else if (comWeapon.equals("Sword")){
                strResult = (this.name + "'s axe was parried by the enemy's sword! " + this.name + " lost...");
            }
        }

        //It will then print out the results of the game including which weapons the player and computer chose,
        //who won the game and why they won.
        System.out.println("");
        System.out.println(this.name + " chose " + weapon + ".");
        System.out.println("The enemy chose " + comWeapon + ".");
        System.out.println("");
        System.out.println(strResult);
    }
}