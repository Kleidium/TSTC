package kcpoland_ma2;

import java.util.Scanner;

public class EmployeeView extends State implements Registry {
    ////Employee Menu State////

    //Member Variables//
    //Determines if the Employee has manager access
    boolean managerLogin = false;

    //Override Methods//
    @Override
    void enter() {
        System.out.println("\nPunching Parrot: Employee View");
    }

    @Override
    void update() {
        //Declarations//

        //Generic
        Scanner input = new Scanner(System.in);
        String selection = "";
        boolean valid = false;

        //Lodging Variables
        String name = "";
        String address = "";
        String phone = "";
        String description = "";
        String ratingString = "";
        float rating = 0.0f;
        String priceString = "";
        float price = 0.0f;

        //Hotel Variables
        String vacancyString = "";
        int vacancies = 0;
        String smokingRoomString = "";
        int smokingRooms = 0;
        String parkingFeeString = "";
        float parkingFee = 0.00f;
        String valetString = "";
        boolean valetService = false;
        String barString = "";
        boolean bar = false;
        String poolString = "";
        boolean pool = false;
        String breakfastString = "";
        boolean freeBreakfast = false;

        //House Variables
        String occupancyString = "";
        int occupancy = 0;
        String bedroomString = "";
        int bedrooms = 0;
        String tinyHomeString = "";
        boolean tinyHome = false;
        String petFriendlyString = "";
        boolean petFriendly = false;

        while (true) {
            //Menu//
            System.out.println("1. Add Lodge");
            System.out.println("2. Remove Lodge");
            System.out.println("3. List Lodges");
            System.out.println("4. Log Out");
            if (this.managerLogin) {
                System.out.println("5. Manager View");
            }

            //Input
            System.out.print("\nSelect an option: ");
            String choice = input.nextLine();

            switch (choice) {
                //Add Lodge//
                case "1":
                    //Lodging Variables//

                    //Prompt for Type
                    valid = false;
                    while (valid == false) {
                        System.out.println("\nWhat type of Lodging would you like to add?");
                        System.out.println("1. Hotel");
                        System.out.println("2. House");

                        System.out.print("\nSelect an option: ");
                        selection = input.nextLine();

                        //Validate
                        if (selection.equals("1") || selection.equals("2")) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please select a number from the menu.");
                        }
                    }

                    //Prompt for Name
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Lodging Name: ");
                        name = input.nextLine();

                        //Validate
                        if (name.length() > 0) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the name of the lodging.");
                        }
                    }

                    //Prompt for Address
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Lodging Address: ");
                        address = input.nextLine();

                        //Validate
                        if (address.length() > 0) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the address of the lodging.");
                        }
                    }

                    //Prompt for Phone Number
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Lodging Phone Number: ");
                        phone = input.nextLine();

                        //Validate
                        if (phone.length() > 0) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the phone number of the lodging.");
                        }
                    }

                    //Prompt for Description
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Lodging Description: ");
                        description = input.nextLine();

                        //Validate
                        if (description.length() > 0) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the description of the lodging.");
                        }
                    }

                    //Prompt for Rating
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Lodging Rating: ");
                        ratingString = input.nextLine();

                        //Validate
                        if (ratingString.length() > 0) {
                            valid = true;
                            rating = Float.parseFloat(ratingString);
                        } else {
                            System.out.println("Invalid input. Please enter the rating of the lodging.");
                        }
                    }

                    //Prompt for Price per Night
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Lodging Price per Night: ");
                        priceString = input.nextLine();

                        //Validate
                        if (priceString.length() > 0) {
                            valid = true;
                            price = Float.parseFloat(priceString);
                        } else {
                            System.out.println("Invalid input. Please enter the price per night of the lodging.");
                        }
                    }

                    if (selection.equals("1")) {
                        //Hotel Variables//

                        //Prompt for Vacancies
                        valid = false;
                        while (valid == false) {
                            System.out.print("\nPlease enter the hotel's number of vacancies: ");
                            vacancyString = input.nextLine();

                            //Validate
                            if (vacancyString.length() > 0) {
                                valid = true;
                                vacancies = Integer.parseInt(vacancyString);
                            } else {
                                System.out.println("Invalid input. Please enter number of Hotel vacancies.");
                            }
                        }

                        //Prompt for Smoking Rooms
                        valid = false;
                        while (valid == false) {
                            System.out.print("\nPlease enter the hotel's number of smoking rooms: ");
                            smokingRoomString = input.nextLine();

                            //Validate
                            if (smokingRoomString.length() > 0) {
                                valid = true;
                                smokingRooms = Integer.parseInt(smokingRoomString);
                            } else {
                                System.out.println("Invalid input. Please enter number of Hotel smoking rooms.");
                            }
                        }

                        //Prompt for Parking Fee
                        valid = false;
                        while (valid == false) {
                            System.out.print("\nPlease enter Hotel parking fee: ");
                            parkingFeeString = input.nextLine();

                            //Validate
                            if (parkingFeeString.length() > 0) {
                                valid = true;
                                parkingFee = Float.parseFloat(parkingFeeString);
                            } else {
                                System.out.println("Invalid input. Please enter the Hotel parking fee.");
                            }
                        }

                        //Valet Service Prompt
                        valid = false;
                        while (valid == false) {
                            System.out.println("\nDoes this Hotel offer valet parking?");
                            System.out.println("\n1. Yes");
                            System.out.println("2. No");

                            System.out.print("\nAnswer: ");
                            valetString = input.nextLine();

                            //Validate
                            switch (valetString) {
                                case "1":
                                    valid = true;
                                    valetService = true;
                                    break;
                                case "2":
                                    valid = true;
                                    valetService = false;
                                    break;
                                default:
                                    System.out.println("Invalid selection. Please select a number from the menu.");
                            }
                        }

                        //Bar Prompt
                        valid = false;
                        while (valid == false) {
                            System.out.println("\nDoes this Hotel have a bar?");
                            System.out.println("\n1. Yes");
                            System.out.println("2. No");

                            System.out.print("\nAnswer: ");
                            barString = input.nextLine();

                            //Validate
                            switch (barString) {
                                case "1":
                                    valid = true;
                                    bar = true;
                                    break;
                                case "2":
                                    valid = true;
                                    bar = false;
                                    break;
                                default:
                                    System.out.println("Invalid selection. Please select a number from the menu.");
                            }
                        }

                        //Pool Prompt
                        valid = false;
                        while (valid == false) {
                            System.out.println("\nDoes this Hotel have a pool?");
                            System.out.println("\n1. Yes");
                            System.out.println("2. No");

                            System.out.print("\nAnswer: ");
                            poolString = input.nextLine();

                            //Validate
                            switch (poolString) {
                                case "1":
                                    valid = true;
                                    pool = true;
                                    break;
                                case "2":
                                    valid = true;
                                    pool = false;
                                    break;
                                default:
                                    System.out.println("Invalid selection. Please select a number from the menu.");
                            }
                        }

                        //Free Breakfast Prompt
                        valid = false;
                        while (valid == false) {
                            System.out.println("\nDoes this Hotel offer free breakfast?");
                            System.out.println("\n1. Yes");
                            System.out.println("2. No");

                            System.out.print("\nAnswer: ");
                            breakfastString = input.nextLine();

                            //Validate
                            switch (breakfastString) {
                                case "1":
                                    valid = true;
                                    freeBreakfast = true;
                                    break;
                                case "2":
                                    valid = true;
                                    freeBreakfast = false;
                                    break;
                                default:
                                    System.out.println("Invalid selection. Please select a number from the menu.");
                            }
                        }

                        //Add Hotel to Lodgings
                        Hotel newHotel = new Hotel(name, address, phone, description, rating, price, vacancies, smokingRooms, parkingFee, valetService, bar, pool, freeBreakfast);
                        lodgings.add(newHotel);
                        System.out.println("Hotel added to system.");
                        return;
                    } else {
                        //House Variables//

                        //Prompt for Max Occupancy
                        valid = false;
                        while (valid == false) {
                            System.out.print("\nPlease enter the max occupancy of the house: ");
                            occupancyString = input.nextLine();

                            //Validate
                            if (occupancyString.length() > 0) {
                                valid = true;
                                occupancy = Integer.parseInt(occupancyString);
                            } else {
                                System.out.println("Invalid input. Please enter the max occupancy of the house.");
                            }
                        }

                        //Prompt for Number of Bedrooms
                        valid = false;
                        while (valid == false) {
                            System.out.print("\nPlease enter the number of bedrooms: ");
                            bedroomString = input.nextLine();

                            //Validate
                            if (bedroomString.length() > 0) {
                                valid = true;
                                bedrooms = Integer.parseInt(bedroomString);
                            } else {
                                System.out.println("Invalid input. Please enter the number of bedrooms in the house.");
                            }
                        }

                        //Tiny Home Prompt
                        valid = false;
                        while (valid == false) {
                            System.out.println("\nIs this House a Tiny Home?");
                            System.out.println("\n1. Yes");
                            System.out.println("2. No");

                            System.out.print("\nAnswer: ");
                            tinyHomeString = input.nextLine();

                            //Validate
                            switch (tinyHomeString) {
                                case "1":
                                    valid = true;
                                    tinyHome = true;
                                    break;
                                case "2":
                                    valid = true;
                                    tinyHome = false;
                                    break;
                                default:
                                    System.out.println("Invalid selection. Please select a number from the menu.");
                            }
                        }

                        //Pet Friendly Prompt
                        valid = false;
                        while (valid == false) {
                            System.out.println("\nIs this House Pet Friendly?");
                            System.out.println("\n1. Yes");
                            System.out.println("2. No");

                            System.out.print("\nAnswer: ");
                            petFriendlyString = input.nextLine();

                            //Validate
                            switch (petFriendlyString) {
                                case "1":
                                    valid = true;
                                    petFriendly = true;
                                    break;
                                case "2":
                                    valid = true;
                                    petFriendly = false;
                                    break;
                                default:
                                    System.out.println("Invalid selection. Please select a number from the menu.");
                            }
                        }

                        //Add House to Lodgings
                        House newHouse = new House(name, address, phone, description, rating, price, occupancy, bedrooms, tinyHome, petFriendly);
                        lodgings.add(newHouse);
                        System.out.println("House added to system.");
                        return;
                    }
                //Remove Lodgings//
                case "2":
                    if (lodgings.size() < 1) {
                        System.out.println("\nNo Lodgings found!");
                    } else {
                        //Display Lodgings
                        System.out.println("\n\tLodgings by Name and Address: \n");

                        for (int i = 0; i < lodgings.size(); i++) {
                            System.out.println((i + 1) + ". " + lodgings.get(i).name + ". " + lodgings.get(i).address);
                        }

                        //Input
                        System.out.print("\nSelect a Lodging to remove: ");
                        selection = input.nextLine();

                        //Confirmation and Removal
                        for (int i = 0; i < lodgings.size(); i++) {
                            if (Integer.toString(i + 1).equals(selection)) {
                                System.out.println("\nRemove this lodging?\n");
                                System.out.println((i + 1) + ". " + lodgings.get(i).name + ": " + lodgings.get(i).address);
                                System.out.println("\n1. Yes");
                                System.out.println("2. No");

                                System.out.print("\nSelect an option: ");
                                selection = input.nextLine();

                                switch (selection) {
                                    //Remove Lodging
                                    case "1":
                                        lodgings.remove(i);
                                        System.out.println("\nLodging removed from list.");
                                        break;
                                    //Keep Lodging
                                    case "2":
                                        break;
                                    //Invalid Selection
                                    default:
                                        System.out.println("Invalid selection. Please select a number from the menu.");
                                }
                                break;
                            } else if (i == (lodgings.size() - 1)) {
                                //Invalid Selection
                                System.out.println("\nInvalid selection. Please try again.");
                            }
                        }
                    }
                    return;
                //List Lodgings//
                case "3":
                    if (lodgings.size() < 1) {
                        System.out.println("\nNo Lodgings found!");
                    } else {
                        //Display Lodgings
                        System.out.println("\n\tLodgings by Name and Address: \n");

                        for (int i = 0; i < lodgings.size(); i++) {
                            System.out.println((i + 1) + ". " + lodgings.get(i).name + ": " + lodgings.get(i).address);
                        }

                        //Input
                        System.out.print("\nSelect a Lodging to view: ");
                        selection = input.nextLine();

                        //Show Information
                        for (int i = 0; i < lodgings.size(); i++) {
                            if (Integer.toString(i + 1).equals(selection)) {
                                System.out.println("\n\tInfo for Lodging #" + selection);
                                System.out.println(lodgings.get(i).toString());
                                break;
                            } else if (i == (lodgings.size() - 1)) {
                                //Invalid Selection
                                System.out.println("\nInvalid selection. Please try again.");
                            }
                        }
                    }
                    return;
                //Log Out//
                case "4":
                    current = login;
                    return;
                //Manager View//
                case "5":
                    if (this.managerLogin) {
                        //Manager Access
                        current = managerView;
                    } else {
                        //No Manager Access
                        System.out.println("Invalid selection. Please select a number from the menu.");
                    }
                    return;
                //Invalid Selection//
                default:
                    System.out.println("Invalid selection. Please select a number from the menu.");
            }
        }
    }
}
