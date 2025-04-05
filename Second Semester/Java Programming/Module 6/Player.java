//Program: Hidden Phrase Program
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program simulates a hangman type word game. The player class contains the player name and amount of guesses they make per round. The guess counter is reset each round.
//Players can guess a single letter or try and guess the entire phrase, chosen among five phrases. Letters are revealed as correct guesses are made. Once the phrase is revealed, the player can quit or start a new round.
//This is the Player class file.


public class Player {
    ////Private Data Fields////
    private String name;
    private int guesses;

    ////Public Functions////

    //Names the player.
    public void setName(String name) {
        this.name = name;
    }

    //Retrieves player name.
    public String getName() {
        return name;
    }

	//Sets the number of phrase guesses.
	public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

	//Retrieves number of phrase guesses.
	public int getGuesses() {
		return guesses;
	}

    //Increment number of phrase guesses.
    public void incGuesses() {
        guesses = guesses + 1;
    }

    //Reset number of phrase guesses.
    public void resetGuesses() {
        guesses = 0;
    }
}