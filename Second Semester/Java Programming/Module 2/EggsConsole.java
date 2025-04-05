//Program: EggsConsole
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program provides a list of prices for eggs, and asks the user to input how many eggs they wish to order. The program then provides the user with
//the receipt for their order.


import java.util.Scanner;

public class EggsConsole {

    public static void main(String[] args) {

	////Declare Variables////

	//Constants
	final float DOZEN_PRICE = 4.50F;
	final float SINGLE_PRICE = 0.50F;
	final float TAX_RATE = 0.08F;

	//Integers
	int dozens;
	int singles;
	int eggTotal;

	//Floats
	float dozensPrice;
	float singlesPrice;
	float subtotal;
	float taxTotal;
	float priceTotal;

	//Scanner Object
	Scanner inputDevice = new Scanner(System.in);
	
	////Welcome Messages////
	System.out.println("");
	System.out.println("Welcome to Egg Basket Farms!");
	System.out.println("");
	System.out.println("Price per dozen eggs: $" + String.format("%.2f", DOZEN_PRICE));
	System.out.println("Price per single egg: $" + String.format("%.2f", SINGLE_PRICE));
	System.out.println("");
	
	////Prompt for order total////
	System.out.print("How many eggs would you like to order? >> ");
	eggTotal = inputDevice.nextInt();

	////Calculate order totals////

	//Dozens
	dozens = eggTotal / 12;
	dozensPrice = dozens * DOZEN_PRICE;

	//Singles
	singles = eggTotal % 12;
	singlesPrice = singles * SINGLE_PRICE;

	//Price Totals
	subtotal = dozensPrice + singlesPrice;
	taxTotal = subtotal * TAX_RATE;
	priceTotal = subtotal + taxTotal;

	////Receipt////
	System.out.println("");
	System.out.println("[Egg Basket Farms Order Receipt]");
	System.out.println("");
	System.out.println("Total number of eggs: " + eggTotal);
	System.out.println("");
	System.out.println(dozens + " dozen @ $" + String.format("%.2f", DOZEN_PRICE) + " each = $" + String.format("%.2f", dozensPrice));
	System.out.println(singles + " individual eggs @ $" + String.format("%.2f", SINGLE_PRICE) + " each = $" + String.format("%.2f", singlesPrice));
	System.out.println("");
	System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
	System.out.println("Tax: $" + String.format("%.2f", taxTotal));
	System.out.println("Total amount due: $" + String.format("%.2f", priceTotal));
	System.out.println("");
	System.out.println("Thank you for shopping at Egg Basket Farms.");
    }

}