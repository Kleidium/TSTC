package kcpoland_ma2;

import java.util.Scanner;

public class CustomerView extends State implements Registry {
    ////Customer Menu State////

    //Member Variables//
    Order order = new Order();

    //Override Methods//
    @Override
    void enter() {
        System.out.println("\nPunching Parrot: Customer View");
    }

    @Override
    void update() {
        //Declarations//
        Scanner input = new Scanner(System.in);
        String selection = "";
        String nightString = "";

        while (true) {
            //Menu//
            System.out.println("1. View Lodgings");
            System.out.println("2. View Order");
            System.out.println("3. Log Out");

            //Input
            System.out.print("\nSelect an option: ");
            String choice = input.nextLine();

            switch (choice) {
                //View Lodgings//
                case "1":
                    //Display Lodgings
                    System.out.println("\n\tLodgings by Name, Address, and Price: \n");

                    for (int i = 0; i < lodgings.size(); i++) {
                        System.out.println((i + 1) + ". " + lodgings.get(i).name + ": " + lodgings.get(i).address + ", $" + String.format("%.2f", lodgings.get(i).basePricePerNight));
                    }
                    System.out.println("0. Cancel");

                    //Input
                    System.out.print("\nSelect a Lodging to view: ");
                    selection = input.nextLine();

                    //Show Information, Prompt for Number of Nights
                    for (int i = 0; i < lodgings.size(); i++) {
                        if (Integer.toString(i + 1).equals(selection)) {
                            System.out.println("\n\tInfo for Lodging #" + selection);
                            System.out.println(lodgings.get(i).toString());

                            System.out.print("\nHow many nights would you like to stay: ");
                            nightString = input.nextLine();

                            //Validate
                            if (nightString.length() > 0) {
                                if (Integer.parseInt(nightString) < 1) {
                                    return;
                                } else {
                                    order.lodgingName = lodgings.get(i).name;
                                    order.numberOfNights = Integer.parseInt(nightString);
                                    order.pricePerNight = lodgings.get(i).basePricePerNight;
                                    System.out.println(nightString + " nights booked.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter number of nights to book or \"0\" to cancel.");
                            }
                            break;
                        } else if (i == (lodgings.size() - 1) && selection.equals("0") == false) {
                            //Invalid Selection
                            System.out.println("\nInvalid selection. Please try again.");
                        }
                    }
                    return;
                //View Order//
                case "2":
                    if (order.lodgingName.equals("")) {
                        //Empty Cart Message
                        System.out.println("\nYour cart is empty.");
                    } else {
                        //Display Order
                        System.out.println("\n\tYour Order:\n");
                        System.out.println("Lodging Name: " + order.lodgingName);
                        System.out.println("Number of Nights: " + order.numberOfNights);
                        System.out.println("Price per Night: $" + String.format("%.2f", order.pricePerNight));
                        System.out.println("\nTotal Cost: $" + String.format("%.2f", (order.pricePerNight * order.numberOfNights)));

                        //Menu
                        System.out.println("1. Confirm Order");
                        System.out.println("2. Cancel Order");
                        System.out.println("3. Return");

                        //Input
                        System.out.print("\nSelect an option: ");
                        selection = input.nextLine();

                        switch (selection) {
                            //Order Confirmed
                            case "1":
                                order.lodgingName = "";
                                order.numberOfNights = 0;
                                order.pricePerNight = 0.0f;
                                System.out.println("\nOrder confirmed!");
                                break;
                            //Order Canceled
                            case "2":
                                order.lodgingName = "";
                                order.numberOfNights = 0;
                                order.pricePerNight = 0.0f;
                                System.out.println("\nOrder canceled.");
                                break;
                            //Return to Menu
                            case "3":
                                break;
                            //Invalid Selection
                            default:
                                System.out.println("Invalid selection. Please select a number from the menu.");
                        }
                    }
                    return;
                //Log Out//
                case "3":
                    current = login;
                    return;
                //Invalid Selection//
                default:
                    System.out.println("Invalid selection. Please select a number from the menu.");
            }
        }
    }

}
