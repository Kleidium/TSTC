package kcpoland_ma3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CustomerView extends State implements Registry {
    ////Customer Menu State////

    //Member Variables//
    Order order = new Order();

    //Override Methods//
    @Override
    void enter() {
        //Load Lodgings
        try {
            this.load();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
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

    
    //Registry Methods//
    
    //Nothing is saved in this state at this time.
    @Override
    public void save() {
    }

    //Load Lodgings
    @Override
    public void load() throws IOException {
        //Declarations//

        //File Handling
        FileReader fr = new FileReader("hotels.txt");
        BufferedReader br = new BufferedReader(fr);
        String[] array = new String[13];
        String s = "";
        String delimiter = "~";

        //Fields//
        
        //Lodgings
        String name;
        String address;
        String phone;
        String description;
        float rating;
        float price;

        //Hotels
        int vacancies;
        int smokingRooms;
        float parkingFee;
        boolean valetParking;
        boolean bar;
        boolean pool;
        boolean hasFreeBreakfast;

        //Houses
        int maxOccupants;
        int numberOfBedrooms;
        boolean tinyHome;
        boolean petFriendly;

        //Load Lodgings//
        
        //Clear Existing List
        lodgings.clear();

        //Hotels
        s = br.readLine();
        while (s != null) {
            array = s.split(delimiter);
            name = array[0];
            address = array[1];
            phone = array[2];
            description = array[3];
            rating = Float.parseFloat(array[4]);
            price = Float.parseFloat(array[5]);
            vacancies = Integer.parseInt(array[6]);
            smokingRooms = Integer.parseInt(array[7]);
            parkingFee = Float.parseFloat(array[8]);
            valetParking = Boolean.parseBoolean(array[9]);
            bar = Boolean.parseBoolean(array[10]);
            pool = Boolean.parseBoolean(array[11]);
            hasFreeBreakfast = Boolean.parseBoolean(array[12]);

            Hotel hotel = new Hotel(name, address, phone, description, rating, price, vacancies, smokingRooms, parkingFee, valetParking, bar, pool, hasFreeBreakfast);
            lodgings.add(hotel);
            s = br.readLine();
        }
        br.close();

        //Houses
        fr = new FileReader("houses.txt");
        br = new BufferedReader(fr);

        s = br.readLine();
        while (s != null) {
            array = s.split(delimiter);
            name = array[0];
            address = array[1];
            phone = array[2];
            description = array[3];
            rating = Float.parseFloat(array[4]);
            price = Float.parseFloat(array[5]);
            maxOccupants = Integer.parseInt(array[6]);
            numberOfBedrooms = Integer.parseInt(array[7]);
            tinyHome = Boolean.parseBoolean(array[8]);
            petFriendly = Boolean.parseBoolean(array[9]);

            House house = new House(name, address, phone, description, rating, price, maxOccupants, numberOfBedrooms, tinyHome, petFriendly);
            lodgings.add(house);
            s = br.readLine();
        }
        br.close();
    }
}
