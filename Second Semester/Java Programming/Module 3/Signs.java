//Program: Custom Signs Program
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program creates a custom sign order object. The user inputs their desired message and the amount of images for each sign, as well as the quantity of signs.
//The program then calculates the price of the user's sign order using 3 different methods. An additional charge is imposed for messages above 10 characters and for orders with more than 1 image.
//This file is the Signs class file.


public class Signs {
	//Declarations section.
	//Declare your variables and constants in this section.
	//Variables and constants declared here can be seen and used by all the functions in this class
	//Variables and constants declared here need to be private and do not need the keyword static.
	
	//Constants//
	private final double TAX_RATE = .0825;
	private final double SIGN_BASE = 20.00;
	private final double CHAR_PRICE = 0.35;
	private final double IMAGE_PRICE = 5.00;
	
	//Doubles//
	private double charCost;
	private double imageCost;
	private double signCost;
	private double subTotal;
	private double taxTotal;
	private double total;

	//Public functions go here. Public functions in a class do not need the keyword static.

	public double getSignPrice(){
	return SIGN_BASE;
	}

	public double getCharPrice(){
	return CHAR_PRICE;
	}

	public double getImagePrice(){
	return IMAGE_PRICE;
	}

	public void printReceipt(String message){
        //This function will calculate the costs for 1 sign with the charge for extra characters plus tax.

		int extraChars;

		//Count all characters in message without whitespace.
		if (message.replace(" ", "").length() > 10) {
        	extraChars = (message.replace(" ", "").length() - 10);
		} else {
			extraChars = 0;
    	}

		//Determine totals.
		charCost = extraChars * CHAR_PRICE;
		signCost = (SIGN_BASE + charCost);
		subTotal = signCost;
		taxTotal = Math.round((subTotal * TAX_RATE) * 100.0) / 100.0;
		total = Math.round((subTotal + taxTotal) * 100.0) / 100.0;

		//It will print out a detailed receipt that includes the message to be printed on the sign, the price for 1 sign,
        //the price for extra characters, the charge for the extra characters, a subtotal, the tax amount to be charged, and total amount due.
        //All currency must be formatted to 2 decimal places and include a dollar sign.

		//Receipt
		System.out.println("");
		System.out.println("***Receipt #1***");
		System.out.println("");
		System.out.println("Base Sign Cost: $" + String.format("%.2f", SIGN_BASE));
		System.out.println("");
		System.out.println("Your Message: " + message);
		System.out.println("Extra Characters: " + extraChars + " @ $" + String.format("%.2f", CHAR_PRICE) + " each = $" + String.format("%.2f", charCost));
		System.out.println("");
		System.out.println("Total Cost per Sign: $" + String.format("%.2f", signCost));
		System.out.println("Sign Quantity: 1");
		System.out.println("");
		System.out.println("Subtotal: $" + String.format("%.2f", subTotal));
		System.out.println("Tax: $" + String.format("%.2f", taxTotal));
		System.out.println("Total: $" + String.format("%.2f", total));
		System.out.println("");
		System.out.println("***Thank you for shopping at Ye Olde Sign Shoppe***");
	}

	public void printReceipt(String message, int quantity){
		//This function will calculate the costs of multiple signs with the charge for extra characters plus tax.

		int extraChars;

		//Count all characters in message without whitespace.
		if (message.replace(" ", "").length() > 10) {
			extraChars = (message.replace(" ", "").length() - 10);
		} else {
			extraChars = 0;
		}

		//Determine totals.
		charCost = extraChars * CHAR_PRICE;
		signCost = SIGN_BASE + charCost;
		subTotal = signCost * quantity;
		taxTotal = Math.round((subTotal * TAX_RATE) * 100.0) / 100.0;
		total = Math.round((subTotal + taxTotal) * 100.0) / 100.0;


		//It will print out a detailed receipt that includes the message to be printed on the sign, the price for 1 sign,
		//the price for extra characters, the charge for the extra characters, a subtotal, the tax amount to be charged, and total amount due.
		//All currency must be formatted to 2 decimal places and include a dollar sign.

		//Receipt
		System.out.println("");
		System.out.println("***Receipt #2***");
		System.out.println("");
		System.out.println("Base Sign Cost: $" + String.format("%.2f", SIGN_BASE));
		System.out.println("");
		System.out.println("Your Message: " + message);
		System.out.println("Extra Characters: " + extraChars + " @ $" + String.format("%.2f", CHAR_PRICE) + " each = $" + String.format("%.2f", charCost));
		System.out.println("");
		System.out.println("Total Cost per Sign: $" + String.format("%.2f", signCost));
		System.out.println("Sign Quantity: " + quantity);
		System.out.println("");
		System.out.println("Subtotal: $" + String.format("%.2f", subTotal));
		System.out.println("Tax: $" + String.format("%.2f", taxTotal));
		System.out.println("Total: $" + String.format("%.2f", total));
		System.out.println("");
		System.out.println("***Thank you for shopping at Ye Olde Sign Shoppe***");
	}

	public void printReceipt(String message, int quantity, int imageQuantity) {
		//This function will calculate the costs of multiple signs with the charge for extra characters and extra images plus tax.

		int extraChars;
		int extraImages;

		//Count all characters in message without whitespace.
		if (message.replace(" ", "").length() > 10) {
			extraChars = (message.replace(" ", "").length() - 10);
		} else {
			extraChars = 0;
		}

		//Only 1 image is included in base sign price.
		if (imageQuantity > 1) {
			extraImages = (imageQuantity - 1);
		} else {
			extraImages = 0;
		}

		//Determine totals.
		charCost = extraChars * CHAR_PRICE;
		imageCost = extraImages * IMAGE_PRICE;
		signCost = SIGN_BASE + charCost + imageCost;
		subTotal = signCost * quantity;
		taxTotal = Math.round((subTotal * TAX_RATE) * 100.0) / 100.0;
		total = Math.round((subTotal + taxTotal) * 100.0) / 100.0;


		//It will print out a detailed receipt that includes the message to be printed on the sign, the price for 1 sign,
		//the price for extra characters, the charge for the extra characters, the price for extra images, the charge for extra images,
		// a subtotal, the tax amount to be charged, and total amount due.
		//All currency must be formatted to 2 decimal places and include a dollar sign.

		//Receipt
		System.out.println("");
		System.out.println("***Receipt #3***");
		System.out.println("");
		System.out.println("Base Sign Cost: $" + String.format("%.2f", SIGN_BASE));
		System.out.println("");
		System.out.println("Your Message: " + message);
		System.out.println("Extra Characters: " + extraChars + " @ $" + String.format("%.2f", CHAR_PRICE) + " each = $" + String.format("%.2f", charCost));
		System.out.println("");
		System.out.println("Additional Images: " + extraImages + " @ $" + String.format("%.2f", IMAGE_PRICE) + " each = $" + String.format("%.2f", imageCost));
		System.out.println("");
		System.out.println("Total Cost per Sign: $" + String.format("%.2f", signCost));
		System.out.println("Sign Quantity: " + quantity);
		System.out.println("");
		System.out.println("Subtotal: $" + String.format("%.2f", subTotal));
		System.out.println("Tax: $" + String.format("%.2f", taxTotal));
		System.out.println("Total: $" + String.format("%.2f", total));
		System.out.println("");
		System.out.println("***Thank you for shopping at Ye Olde Sign Shoppe***");
	}
}