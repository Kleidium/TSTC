//Program: Custom Signs Program
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program creates a custom sign order object. The user inputs their desired message and the amount of images for each sign, as well as the quantity of signs.
//The program then calculates the price of the user's sign order using 3 different methods. An additional charge is imposed for messages above 10 characters and for orders with more than 1 image.
//This file is the Main program file.


import java.util.Scanner;

public class Main {
    //This is the global scope section of the program. Global variablesAll variables and constants declared here can be seen and used by the entire program.
    //DO NOT declare variables and constants in this section.

    public static void main(String[] args) {
    	//Declarations section. Declare the variables and constants you will need in this section.

		//Strings//
		String strMessage;

		//Integers//
		int quantity;
		int imageQuantity;
	
		//Objects//
    	Signs signOrder = new Signs(); //This creates an object of the Signs class. DO NOT MODIFY.
		Scanner inputDevice = new Scanner(System.in);

    	// Print a welcome message that includes prices for the user to see. Make it look good. DO NOT print it on 1 line.
		System.out.println("Welcome to Ye Olde Sign Shoppe.");
		System.out.println("");
		System.out.println("Base price per sign: $" + String.format("%.2f", signOrder.getSignPrice()));
		System.out.println("Price per character over 10: $" + String.format("%.2f", signOrder.getCharPrice()));
		System.out.println("Price per additional image: $" + String.format("%.2f", signOrder.getImagePrice()));
		System.out.println("");

        //Ask the user what message they want printed on their sign.
		System.out.print("What message would you like on your sign? >> ");
		strMessage = inputDevice.nextLine();

        // Asking the user how many signs they want
		System.out.print("How many signs would you like? >> ");
		quantity = inputDevice.nextInt();

        // Asking the user how many images they want on their sign(s)
		System.out.print("How many images on each sign? >> ");
		imageQuantity = inputDevice.nextInt();

        // Call the 3 overloaded methods from the Sign class using the "signOrder" object.
        //DO NOT MODIFY the following 3 lines of code.
        signOrder.printReceipt(strMessage);
        signOrder.printReceipt(strMessage, quantity);
        signOrder.printReceipt(strMessage, quantity, imageQuantity);
    }
}
