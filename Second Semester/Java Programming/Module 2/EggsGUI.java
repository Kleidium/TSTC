//Program: EggsGUI
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This GUI program provides a list of prices for eggs, and asks the user to input how many eggs they wish to order. The program then provides the user with
//a receipt for their order.


import javax.swing.JOptionPane;

public class EggsGUI {

    public static void main(String[] args) {

	////Declare Variables////

	//Constants
	final float DOZEN_PRICE = 4.50F;
	final float SINGLE_PRICE = 0.50F;
	final float TAX_RATE = 0.08F;

	//Strings
	String eggTotalString;

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
	
	////Welcome Message, Order Prompt////
	eggTotalString = JOptionPane.showInputDialog(null, "Welcome to Egg Basket Farms!" + "\n\nPrice per dozen eggs: $" + String.format("%.2f", DOZEN_PRICE) + "\nPrice per single egg: $" + String.format("%.2f", SINGLE_PRICE) + "\n\nHow many eggs would you like to order?", "Egg Basket Farms Order Window", JOptionPane.QUESTION_MESSAGE);
	eggTotal = Integer.parseInt(eggTotalString);

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
	JOptionPane.showMessageDialog(null, "Total number of eggs: " + eggTotal + "\n\n" + dozens + " dozen @ $" + String.format("%.2f", DOZEN_PRICE) + " each = $" + String.format("%.2f", dozensPrice) + "\n" + singles + " individual eggs @ $" + String.format("%.2f", SINGLE_PRICE) + " each = $" + String.format("%.2f", singlesPrice) + 
	"\n\nSubtotal: $" + String.format("%.2f", subtotal) + "\nTax: $" + String.format("%.2f", taxTotal) + "\nTotal amount due: $" + String.format("%.2f", priceTotal) + "\n\nThank you for shopping at Egg Basket Farms.", "Egg Basket Farms Receipt", JOptionPane.PLAIN_MESSAGE);
    }

}