//Program: Hidden Phrase Program
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program simulates a hangman type word game. The player class contains the player name and amount of guesses they make per round. The guess counter is reset each round.
//Players can guess a single letter or try and guess the entire phrase, chosen among five phrases. Letters are revealed as correct guesses are made. Once the phrase is revealed, the player can quit or start a new round.
//This is the Main program file.


import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ////Declarations////

        //Variables
        String name;
        int choice = 0;

        //Objects
        Scanner inputDevice = new Scanner(System.in);
        Player player = new Player();


        ////Welcome Message////
        System.out.println("");
        System.out.println("Welcome. Can you guess the hidden phrase..?");
        System.out.println("");


        ////Assign Name, Initialize Guesses////
        System.out.print("Please enter your name: >> ");
        name = inputDevice.nextLine();
        player.setName(name);
        player.setGuesses(0);
        System.out.println("");
        System.out.println("So, your name is " + name + "...let us begin.");


        ////First Round////
        beginRound(player, selectPhrase());


		////Subsequent Rounds////
        while (choice != 2) {
            //Play again?
            System.out.println("");
            System.out.println("Would you like to play again, " + name + "?");
            System.out.println("");
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println("");
            System.out.print("Select an option: >> ");
            choice = inputDevice.nextInt();

            //Invalid selection
            if (choice < 1 || choice > 2) {
                System.out.println("");
                System.out.println("Invalid selection. Please select choice 1 or 2.");
            }

            //Another round
            if (choice == 1) {
                beginRound(player, selectPhrase());
            }

            //Exit
            if (choice == 2) {
                System.out.println("");
				System.out.println("Very well. Goodbye, " + name + ".");
            }
        }
    }

    
    public static String selectPhrase() {
        ////Declarations////
        String phrase = "";
        Random random = new Random();
        int choice = random.nextInt(5);


        ////Determine Phrase////
        if (choice == 0) {
            phrase = "Mischief Managed";
        }

        if (choice == 1) {
            phrase = "Final Fantasy";
        }

        if (choice == 2) {
            phrase = "Winter Is Coming";
        }

        if (choice == 3) {
            phrase = "As Above So Below";
        }

        if (choice == 4) {
            phrase = "Fear Is The Mind Killer";
        }

        return phrase;
    }


	public static void beginRound(Player player, String phrase) {
        ////Declarations////
        Scanner inputDevice = new Scanner(System.in);
        StringBuilder guess = new StringBuilder("");
        StringBuilder hiddenPhrase = new StringBuilder(phrase);


        ////Hide Phrase////
        for (int index = 0; index < hiddenPhrase.length(); index++) {
            if (hiddenPhrase.charAt(index) != ' ') {
                hiddenPhrase.setCharAt(index, '#');
            }
        }


        ////Reset Number of Player Guesses////
        player.resetGuesses();


        ////Guess Loop////
        while (hiddenPhrase.indexOf("#") != -1) {
            //Display hidden phrase
            System.out.println("");
            System.out.println(hiddenPhrase);

            //Ask for guess
            System.out.println("");
            System.out.print("Your guess: >> ");
            guess.replace(0, guess.length(), inputDevice.nextLine());

            //Check For Matches//
            if (guess.length() == 1) {
                //Single Character//
                player.incGuesses();

                //Check for number of matches
                int matches = 0;
                for (int index = 0; index < hiddenPhrase.length(); index++) {
                    if (Character.toLowerCase(phrase.charAt(index)) == Character.toLowerCase(guess.charAt(0))) {
                        hiddenPhrase.setCharAt(index, phrase.charAt(index));
                        matches = matches + 1;
                    }
                }

                if (matches == 1) {
                    //One match made
                    System.out.println("");
                    System.out.println("The phrase contains " + matches + " " + guess + ".");
                } else if (matches > 1){
                    //Multiple matches made
                    System.out.println("");
                    System.out.println("The phrase contains " + matches + " " + guess + "'s!");
                } else {
                    //No matches made
                    System.out.println("");
                    System.out.println("There are no " + guess + "'s in the phrase. Guess again.");
                }

            } else if (guess.length() > 1) {
                //Multi-character//
                player.incGuesses();

                if (phrase.equalsIgnoreCase(guess.toString())) {
                    //Correct phrase
                    hiddenPhrase.replace(0, hiddenPhrase.length(), phrase);
                    System.out.println("");
                    System.out.println("Correct! You've guessed the entire phrase!");
                } else {
                    //Incorrect phrase
                    System.out.println("");
                    System.out.println("\"" + guess + "\" is not the phrase. Guess again.");
                }

            } else {
                //Invalid Input//
                System.out.println("");
                System.out.println("Invalid input. Please enter a letter or try to guess the entire phrase.");
            }

        }

        
        ////Display Uncovered Phrase, Show Amount of Guesses////
        System.out.println("");
        System.out.println("Congratulations, " + player.getName() + "! The phrase is \"" + phrase + "\".");
        System.out.println("Number of guesses: " + player.getGuesses());
    }
}