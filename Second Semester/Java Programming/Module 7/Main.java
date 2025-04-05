//Program: Widgets Program
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program is an ordering platform for Pillows-a-Plenty, a custom pillow seller. Discounts are possible for certain order quantities. Shipping is free for orders above $50.00.
//This program allows multiple orders to be placed, and provides a way to view the total sales for the day.
//This is the Main program file.

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    ////Main Program////
    public static void main(String[] args) {
        //Declarations//

        //Integers
        int choice = 0;

        //Objects
        Scanner inputDevice = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<Order>();
		double[][] prices = 
		{ {15.00, 14.00, 12.00, 10.00},
		{20.00, 19.00, 17.00, 15.00},
		{25.00, 24.00, 22.00, 20.00} };

        //Welcome Message//
        System.out.println("");
        System.out.println("Welcome to Pillows-a-Plenty!");

        //Main Menu Loop//
        while (choice != 3) {
            //Price Guide//
            System.out.println("");
            System.out.println("The more pillows ordered, the cheaper the price per pillow.");
            System.out.println("Orders above $50.00 have free shipping.");
            System.out.println("");
            System.out.println("Pillow Prices:");
            System.out.println("   _________________________________________________");
            System.out.println("   Discount Tiers:  <3  |   3-4   |   5-9   |  >=10");
            System.out.println("   _________________________________________________");
            System.out.println("   Small:        $" + String.format("%.2f", prices[0][0]) + " | $" + String.format("%.2f", prices[0][1]) + "  | $" + String.format("%.2f", prices[0][2]) + "  | $" + String.format("%.2f", prices[0][3]));
            System.out.println("   Medium:       $" + String.format("%.2f", prices[1][0]) + " | $" + String.format("%.2f", prices[1][1]) + "  | $" + String.format("%.2f", prices[1][2]) + "  | $" + String.format("%.2f", prices[1][3]));
            System.out.println("   Large:        $" + String.format("%.2f", prices[2][0]) + " | $" + String.format("%.2f", prices[2][1]) + "  | $" + String.format("%.2f", prices[2][2]) + "  | $" + String.format("%.2f", prices[2][3]));
            System.out.println("   _________________________________________________");
            System.out.println("_______________________________________________________");
            System.out.println("Shipping Tiers:  < $25.00 | $25.00 - $49.99 | >= $50.00");
            System.out.println("_______________________________________________________");
            System.out.println("Shipping Fees:      $5.00 |     $10.00      |     $0.00");
            System.out.println("_______________________________________________________");

            //Main Menu//
            System.out.println("");
            System.out.println("Pillows-a-Plenty: Main Menu");
            System.out.println("");
            System.out.println("1. Place Order");
            System.out.println("2. Total Sales");
            System.out.println("3. Exit Program");
            System.out.println("");
            System.out.print("Select an option: >> ");
            choice = inputDevice.nextInt();

            //Invalid Selection
            if (choice == 0 || choice > 3) {
                System.out.println("");
                System.out.println("Invalid selection. Please select a choice from 1-3.");
            }

            //Place Order
            if (choice == 1) {
                newOrder(prices, orders);
            }

            //Total Sales
            if (choice == 2) {
                totalSales(orders);
            }

            //Exit
            if (choice == 3) {
				System.out.println("");
				System.out.println("Exiting program. Thank you for shopping at Pillows-a-Plenty!");
            }
        }
    }

    ////Show Total Sales////
    public static void totalSales(ArrayList<Order> orders) {
        //Declarations//
        int totalSmalls = 0;
        int totalMediums = 0;
        int totalLarges = 0;
        double grandTotal = 0.00;

        //Add up all order fields.//
        for( int i = 0; i < orders.size(); ++i) {
            totalSmalls = (totalSmalls + orders.get(i).getSmalls());
            totalMediums = (totalMediums + orders.get(i).getMediums());
            totalLarges = (totalLarges + orders.get(i).getLarges());
            grandTotal = (grandTotal + orders.get(i).getTotal());
        }

        //Display total sales.//
        System.out.println("");
        System.out.println("______________________");
        System.out.println("Total Sales for Today:");
        System.out.println("");
        System.out.println("Small Pillows: " + totalSmalls);
        System.out.println("Medium Pillows: " + totalMediums);
        System.out.println("Large Pillows: " + totalLarges);
        System.out.println("");
        System.out.println("Total Sales: $" + String.format("%.2f", grandTotal));
        System.out.println("______________________");

    }


    ////Submit Order////
    public static void submitOrder(ArrayList<Order> orders, int smalls, int mediums, int larges, double total) {
        //Create new order object, populate fields.
        Order order = new Order();
        order.setSmalls(smalls);
        order.setMediums(mediums);
        order.setLarges(larges);
        order.setTotal(total);

        //Add to order list.
        orders.add(order);
    }


    ////Begin New Order////
	public static void newOrder(double[][] prices, ArrayList<Order> orders) {
        //Declarations//
        int choice = 0;
		int quantity = 0;
		int smallQuantity = 0;
		int mediumQuantity = 0;
		int largeQuantity = 0;
        Scanner inputDevice = new Scanner(System.in);
		

        //Order Loop//
        while (choice != 4) {
            //Reset Choice//
            choice = 0;

            //Order Menu//
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                //Price Guide//
                System.out.println("");
                System.out.println("Pillow Prices:");
                System.out.println("   _________________________________________________");
                System.out.println("   Discount Tiers:  <3  |   3-4   |   5-9   |  >=10");
                System.out.println("   _________________________________________________");
                System.out.println("   Small:        $" + String.format("%.2f", prices[0][0]) + " | $" + String.format("%.2f", prices[0][1]) + "  | $" + String.format("%.2f", prices[0][2]) + "  | $" + String.format("%.2f", prices[0][3]));
                System.out.println("   Medium:       $" + String.format("%.2f", prices[1][0]) + " | $" + String.format("%.2f", prices[1][1]) + "  | $" + String.format("%.2f", prices[1][2]) + "  | $" + String.format("%.2f", prices[1][3]));
                System.out.println("   Large:        $" + String.format("%.2f", prices[2][0]) + " | $" + String.format("%.2f", prices[2][1]) + "  | $" + String.format("%.2f", prices[2][2]) + "  | $" + String.format("%.2f", prices[2][3]));
                System.out.println("   _________________________________________________");
                System.out.println("_______________________________________________________");
                System.out.println("Shipping Tiers:  < $25.00 | $25.00 - $49.99 | >= $50.00");
                System.out.println("_______________________________________________________");
                System.out.println("Shipping Fees:      $5.00 |     $10.00      |     $0.00");
                System.out.println("_______________________________________________________");

                //Order Menu//
                System.out.println("");
                System.out.println("Order Menu:");
                System.out.println("");
                System.out.println("1. Order Small Pillows");
                System.out.println("2. Order Medium Pillows");
                System.out.println("3. Order Large Pillows");
				System.out.println("4. Complete Order");
				System.out.println("");
                System.out.print("Select an option: >> ");
                choice = inputDevice.nextInt();

                //Invalid Selection
                if (choice == 0 || choice > 4) {
                    System.out.println("");
                    System.out.println("Invalid selection. Please select a choice from 1-4.");
                }

                //Small Pillows
                if (choice == 1) {
					System.out.print("How many Small Pillows would you like? >> ");
                	quantity = inputDevice.nextInt();
                    smallQuantity = smallQuantity + quantity;
                }

                //Medium Pillows
                if (choice == 2) {
					System.out.print("How many Medium Pillows would you like? >> ");
                	quantity = inputDevice.nextInt();
                    mediumQuantity = mediumQuantity + quantity;
                }

				//Large Pillows
				if (choice == 3) {
					System.out.print("How many Large Pillows would you like? >> ");
                	quantity = inputDevice.nextInt();
                    largeQuantity = largeQuantity + quantity;
				}

				//Complete Order
				if (choice == 4) {
                    if (smallQuantity > 0 || mediumQuantity > 0 || largeQuantity > 0) {
                        //Determine Prices//
                        final double TAX_RATE = 0.0825;
                        double taxTotal = 0.00;
                        double shipping = 5.00;
                        double subtotal = 0.00;
                        double total = 0.00;
                        double priceSmall = prices[0][0];
                        double priceMedium = prices[1][0];
                        double priceLarge = prices[2][0];
                        double smallTotal = 0.00;
                        double mediumTotal = 0.00;
                        double largeTotal = 0.00;
                        int[] priceRanges = { 1, 3, 5, 10 };
                        int index = 3;

                        //Check for negative quantities
                        if (smallQuantity < 0) {
                            smallQuantity = 0;
                        }

                        if (mediumQuantity < 0) {
                            mediumQuantity = 0;
                        }

                        if (largeQuantity < 0) {
                            largeQuantity = 0;
                        }

                        //Small Rates
                        while( index > 0 && smallQuantity < priceRanges[index]) {
                            --index;
                        }
                        priceSmall = prices[0][index];
                        smallTotal = priceSmall * smallQuantity;
                        index = 3;

                        //Medium Rates
                        while( index > 0 && mediumQuantity < priceRanges[index]) {
                            --index;
                        }
                        priceMedium = prices[1][index];
                        mediumTotal = priceMedium * mediumQuantity;
                        index = 3;

                        //Large Rates
                        while( index > 0 && largeQuantity < priceRanges[index]) {
                            --index;
                        }
                        priceLarge = prices[2][index];
                        largeTotal = priceLarge * largeQuantity;
                        index = 3;

                        //Subtotal
                        subtotal = (smallTotal + mediumTotal + largeTotal);

                        //Taxes
                        taxTotal = Math.round((subtotal * TAX_RATE) * 100.0) / 100.0;

                        //Shipping
                        if (subtotal >= 25.00) {
                            shipping = 10.00;
                        }

                        if (subtotal >= 50.00) {
                            shipping = 0.00;
                        }

                        //Total
                        total = Math.round((subtotal + taxTotal + shipping) * 100.0) / 100.0;

                        //Receipt
                        System.out.println("");
                        System.out.println("************* Pillows-a-Plenty Receipt *************");
                        System.out.println("");
                        System.out.println(String.format("%5d", smallQuantity) + "  small pillows  @ $" + String.format("%2.2f", priceSmall) + " each: $" + String.format("%10.2f", smallTotal));
                        System.out.println(String.format("%5d", mediumQuantity) + " medium pillows  @ $" + String.format("%2.2f", priceMedium) + " each: $" + String.format("%10.2f", mediumTotal));
                        System.out.println(String.format("%5d", largeQuantity) + "  large pillows  @ $" + String.format("%2.2f", priceLarge) + " each: $" + String.format("%10.2f", largeTotal));
                        System.out.println("");
                        System.out.println("    Subtotal:                        $" + String.format("%10.2f", subtotal));
                        System.out.println("    Tax:                             $" + String.format("%10.2f", taxTotal));
                        System.out.println("    Shipping:                        $" + String.format("%10.2f", shipping));
                        System.out.println("");
                        System.out.println("    Total Due:                       $" + String.format("%10.2f", total));
                        System.out.println("");
                        System.out.println("    Thank you for shopping at Pillows-a-Plenty!!");
                        System.out.println("____________________________________________________");
                        System.out.println("");
                        System.out.println("Order placed. Returning to Main Menu.");

                        //Add order to order list
                        submitOrder(orders, smallQuantity, mediumQuantity, largeQuantity, total);
                    } else {
                        //No items ordered
                        System.out.println("");
                        System.out.println("No items were ordered. Returning to Main Menu.");
                    }
				}
            }
        }
    }
}