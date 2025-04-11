package kcpoland_ma3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeView extends State implements Registry {
    ////Employee Menu State////

    //Member Variables//
    //Determines if the Employee has manager access
    boolean managerLogin = false;

    //State Methods//
    @Override
    void enter() {
        //Load Lodgings
        try {
            this.load();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
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
            System.out.println("1. Add Lodging");
            System.out.println("2. Remove Lodging");
            System.out.println("3. List Lodgings");
            System.out.println("4. Edit Lodgings");
            System.out.println("5. Log Out");
            if (this.managerLogin) {
                System.out.println("6. Manager View");
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
                            try {
                                rating = Float.parseFloat(ratingString);
                            } catch (Exception e) {
                                valid = false;
                                System.out.println("Invalid input. Rating must be a number.");
                            }
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
                            try {
                                price = Float.parseFloat(priceString);
                            } catch (Exception e) {
                                valid = false;
                                System.out.println("Invalid input. Price must be a number.");
                            }
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
                                try {
                                    vacancies = Integer.parseInt(vacancyString);
                                } catch (Exception e) {
                                    valid = false;
                                    System.out.println("Invalid input. Input must be a whole number.");
                                }
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
                                try {
                                    smokingRooms = Integer.parseInt(smokingRoomString);
                                } catch (Exception e) {
                                    valid = false;
                                    System.out.println("Invalid input. Input must be a whole number.");
                                }
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
                                try {
                                    parkingFee = Float.parseFloat(parkingFeeString);
                                } catch (Exception e) {
                                    valid = false;
                                    System.out.println("Invalid input. Parking fee must be a number.");
                                }
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
                        try {
                            this.save();
                        } catch (Exception e) {
                            System.out.println("Message: " + e);
                        }
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
                                try {
                                    occupancy = Integer.parseInt(occupancyString);
                                } catch (Exception e) {
                                    valid = false;
                                    System.out.println("Invalid input. Input must be a whole number.");
                                }
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
                                try {
                                    bedrooms = Integer.parseInt(bedroomString);
                                } catch (Exception e) {
                                    valid = false;
                                    System.out.println("Invalid input. Input must be a whole number.");
                                }
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
                        try {
                            this.save();
                        } catch (Exception e) {
                            System.out.println("Message: " + e);
                        }
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
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
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
                //Edit Lodgings//
                case "4":
                    if (lodgings.size() < 1) {
                        System.out.println("\nNo Lodgings found!");
                    } else {
                        //Display Lodgings
                        System.out.println("\n\tLodgings by Name and Address: \n");

                        for (int i = 0; i < lodgings.size(); i++) {
                            System.out.println((i + 1) + ". " + lodgings.get(i).name + ". " + lodgings.get(i).address);
                        }

                        //Input
                        System.out.print("\nSelect a Lodging to edit: ");
                        selection = input.nextLine();

                        //Editing Menu
                        for (int i = 0; i < lodgings.size(); i++) {
                            if (Integer.toString(i + 1).equals(selection)) {
                                System.out.println("\n\tEdit this lodging?");
                                System.out.println(lodgings.get(i).toString());
                                System.out.println("\n1. Edit Name");
                                System.out.println("2. Edit Address");
                                System.out.println("3. Edit Phone Number");
                                System.out.println("4. Edit Description");
                                System.out.println("5. Edit Rating");
                                System.out.println("6. Edit Price");
                                if (lodgings.get(i) instanceof Hotel) {
                                    System.out.println("7. Edit Vacancies");
                                    System.out.println("8. Edit Smoking Rooms");
                                    System.out.println("9. Edit Parking Fee");
                                    System.out.println("10. Edit Valet Availability");
                                    System.out.println("11. Edit Bar Availability");
                                    System.out.println("12. Edit Pool Availability");
                                    System.out.println("13. Edit Breakfast Availability");
                                } else {
                                    System.out.println("7. Edit Max Occupancy");
                                    System.out.println("8. Edit Bedroom Count");
                                    System.out.println("9. Edit Tiny Home Status");
                                    System.out.println("10. Edit Pet Friendly Status");
                                }

                                System.out.print("\nSelect an option: ");
                                selection = input.nextLine();

                                switch (selection) {
                                    //Edit Name
                                    case "1":
                                        //Prompt for Name
                                        valid = false;
                                        while (valid == false) {
                                            System.out.print("\nPlease enter new Lodging Name: ");
                                            name = input.nextLine();

                                            //Validate
                                            if (name.length() > 0) {
                                                valid = true;
                                            } else {
                                                System.out.println("Invalid input. Please enter the name of the lodging.");
                                            }
                                        }
                                        //Update
                                        lodgings.get(i).name = name;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nLodging name updated.");
                                        break;
                                    //Edit Address
                                    case "2":
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
                                        //Update
                                        lodgings.get(i).address = address;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nLodging address updated.");
                                        break;
                                    //Edit Phone Number
                                    case "3":
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
                                        //Update
                                        lodgings.get(i).phoneNumber = phone;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nLodging phone number updated.");
                                        break;
                                    //Edit Description
                                    case "4":
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
                                        //Update
                                        lodgings.get(i).description = description;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nLodging description updated.");
                                        break;
                                    //Edit Rating
                                    case "5":
                                        //Prompt for Rating
                                        valid = false;
                                        while (valid == false) {
                                            System.out.print("\nPlease enter Lodging Rating: ");
                                            ratingString = input.nextLine();

                                            //Validate
                                            if (ratingString.length() > 0) {
                                                valid = true;
                                                try {
                                                    rating = Float.parseFloat(ratingString);
                                                } catch (Exception e) {
                                                    valid = false;
                                                    System.out.println("Invalid input. Rating must be a number.");
                                                }
                                            } else {
                                                System.out.println("Invalid input. Please enter the rating of the lodging.");
                                            }
                                        }
                                        //Update
                                        lodgings.get(i).rating = rating;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nLodging rating updated.");
                                        break;
                                    //Edit Price
                                    case "6":
                                        //Prompt for Price per Night
                                        valid = false;
                                        while (valid == false) {
                                            System.out.print("\nPlease enter Lodging Price per Night: ");
                                            priceString = input.nextLine();

                                            //Validate
                                            if (priceString.length() > 0) {
                                                valid = true;
                                                try {
                                                    price = Float.parseFloat(priceString);
                                                } catch (Exception e) {
                                                    valid = false;
                                                    System.out.println("Invalid input. Price must be a number.");
                                                }
                                            } else {
                                                System.out.println("Invalid input. Please enter the price per night of the lodging.");
                                            }
                                        }
                                        //Update
                                        lodgings.get(i).basePricePerNight = price;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nLodging price updated.");
                                        break;
                                    //Edit Vacancies/Max Occupancy
                                    case "7":
                                        if (lodgings.get(i) instanceof Hotel) {
                                            //Prompt for Vacancies
                                            valid = false;
                                            while (valid == false) {
                                                System.out.print("\nPlease enter the hotel's number of vacancies: ");
                                                vacancyString = input.nextLine();

                                                //Validate
                                                if (vacancyString.length() > 0) {
                                                    valid = true;
                                                    try {
                                                        vacancies = Integer.parseInt(vacancyString);
                                                    } catch (Exception e) {
                                                        valid = false;
                                                        System.out.println("Invalid input. Input must be a whole number.");
                                                    }
                                                } else {
                                                    System.out.println("Invalid input. Please enter number of Hotel vacancies.");
                                                }
                                            }
                                            //Update
                                            Hotel cast = (Hotel) lodgings.get(i);
                                            cast.vacancies = vacancies;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHotel vacancy count updated.");
                                        } else {
                                            //Prompt for Max Occupancy
                                            valid = false;
                                            while (valid == false) {
                                                System.out.print("\nPlease enter the max occupancy of the house: ");
                                                occupancyString = input.nextLine();

                                                //Validate
                                                if (occupancyString.length() > 0) {
                                                    valid = true;
                                                    try {
                                                        occupancy = Integer.parseInt(occupancyString);
                                                    } catch (Exception e) {
                                                        valid = false;
                                                        System.out.println("Invalid input. Input must be a whole number.");
                                                    }
                                                } else {
                                                    System.out.println("Invalid input. Please enter the max occupancy of the house.");
                                                }
                                            }
                                            //Update
                                            House cast = (House) lodgings.get(i);
                                            cast.maxOccupants = occupancy;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHouse occupancy count updated.");
                                        }
                                        break;
                                    //Edit Smoking Rooms/Bedroom Count
                                    case "8":
                                        if (lodgings.get(i) instanceof Hotel) {
                                            //Prompt for Smoking Rooms
                                            valid = false;
                                            while (valid == false) {
                                                System.out.print("\nPlease enter the hotel's number of smoking rooms: ");
                                                smokingRoomString = input.nextLine();

                                                //Validate
                                                if (smokingRoomString.length() > 0) {
                                                    valid = true;
                                                    try {
                                                        smokingRooms = Integer.parseInt(smokingRoomString);
                                                    } catch (Exception e) {
                                                        valid = false;
                                                        System.out.println("Invalid input. Input must be a whole number.");
                                                    }
                                                } else {
                                                    System.out.println("Invalid input. Please enter number of Hotel smoking rooms.");
                                                }
                                            }
                                            //Update
                                            Hotel cast = (Hotel) lodgings.get(i);
                                            cast.smokingRooms = smokingRooms;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHotel smoking room count updated.");
                                        } else {
                                            //Prompt for Number of Bedrooms
                                            valid = false;
                                            while (valid == false) {
                                                System.out.print("\nPlease enter the number of bedrooms: ");
                                                bedroomString = input.nextLine();

                                                //Validate
                                                if (bedroomString.length() > 0) {
                                                    valid = true;
                                                    try {
                                                        bedrooms = Integer.parseInt(bedroomString);
                                                    } catch (Exception e) {
                                                        valid = false;
                                                        System.out.println("Invalid input. Input must be a whole number.");
                                                    }
                                                } else {
                                                    System.out.println("Invalid input. Please enter the number of bedrooms in the house.");
                                                }
                                            }
                                            //Update
                                            House cast = (House) lodgings.get(i);
                                            cast.numberOfBedrooms = bedrooms;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHouse bedroom count updated.");
                                        }
                                        break;
                                    //Edit Parking Fee/Tiny Home Status
                                    case "9":
                                        if (lodgings.get(i) instanceof Hotel) {
                                            //Prompt for Parking Fee
                                            valid = false;
                                            while (valid == false) {
                                                System.out.print("\nPlease enter Hotel parking fee: ");
                                                parkingFeeString = input.nextLine();

                                                //Validate
                                                if (parkingFeeString.length() > 0) {
                                                    valid = true;
                                                    try {
                                                        parkingFee = Float.parseFloat(parkingFeeString);
                                                    } catch (Exception e) {
                                                        valid = false;
                                                        System.out.println("Invalid input. Parking fee must be a number.");
                                                    }
                                                } else {
                                                    System.out.println("Invalid input. Please enter the Hotel parking fee.");
                                                }
                                            }
                                            //Update
                                            Hotel cast = (Hotel) lodgings.get(i);
                                            cast.parkingFee = parkingFee;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHotel parking fee updated.");
                                        } else {
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
                                            //Update
                                            House cast = (House) lodgings.get(i);
                                            cast.tinyHome = tinyHome;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHouse tiny home status updated.");
                                        }
                                        break;
                                    //Edit Valet Availability/Pet Friendly Status
                                    case "10":
                                        if (lodgings.get(i) instanceof Hotel) {
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
                                            //Update
                                            Hotel cast = (Hotel) lodgings.get(i);
                                            cast.valetParking = valetService;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHotel valet availability updated.");
                                        } else {
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
                                            //Update
                                            House cast = (House) lodgings.get(i);
                                            cast.petFriendly = petFriendly;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHouse pet friendly status updated.");
                                        }
                                        break;
                                    //Edit Bar Availability
                                    case "11":
                                        if (lodgings.get(i) instanceof Hotel) {
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
                                            //Update
                                            Hotel cast = (Hotel) lodgings.get(i);
                                            cast.bar = bar;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHotel bar availability updated.");
                                        } else {
                                            System.out.println("Invalid selection. Please select a number from the menu.");
                                        }
                                        break;
                                    //Edit Pool Availability
                                    case "12":
                                        if (lodgings.get(i) instanceof Hotel) {
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
                                            //Update
                                            Hotel cast = (Hotel) lodgings.get(i);
                                            cast.pool = pool;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHotel pool availability updated.");
                                        } else {
                                            System.out.println("Invalid selection. Please select a number from the menu.");
                                        }
                                        break;
                                    //Edit Breakfast Availability
                                    case "13":
                                        if (lodgings.get(i) instanceof Hotel) {
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
                                            //Update
                                            Hotel cast = (Hotel) lodgings.get(i);
                                            cast.hasFreeBreakfast = freeBreakfast;
                                            try {
                                                this.save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
                                            System.out.println("\nHotel breakfast availability updated.");
                                        } else {
                                            System.out.println("Invalid selection. Please select a number from the menu.");
                                        }
                                        break;
                                    //Invalid Selection
                                    default:
                                        System.out.println("Invalid selection. Please select a number from the menu.");
                                }
                                return;
                            } else if (i == (lodgings.size() - 1)) {
                                //Invalid Selection
                                System.out.println("\nInvalid selection. Please try again.");
                            }
                        }
                    }
                    return;
                //Log Out//
                case "5":
                    current = login;
                    return;
                //Manager View//
                case "6":
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

    //Registry Methods//
    
    //Save Hotels and Houses to files
    @Override
    public void save() throws IOException {
        ////Declarations////

        //File Handling
        FileWriter fw = new FileWriter("hotels.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        String d = "~";

        //Write Hotels
        for (int i = 0; i < lodgings.size(); i++) {
            if (lodgings.get(i) instanceof Hotel) {
                Hotel cast = (Hotel) lodgings.get(i);
                bw.append(cast.name + d + cast.address + d + cast.phoneNumber + d + cast.description + d + cast.rating + d + cast.basePricePerNight + d + cast.vacancies + d
                        + cast.smokingRooms + d + cast.parkingFee + d + cast.valetParking + d + cast.bar + d + cast.pool + d + cast.hasFreeBreakfast + "\r\n");
                System.out.println(cast.name + " written to file.");
            }
        }
        bw.close();

        //Write Houses
        fw = new FileWriter("houses.txt");
        bw = new BufferedWriter(fw);
        for (int i = 0; i < lodgings.size(); i++) {
            if (lodgings.get(i) instanceof House) {
                House cast = (House) lodgings.get(i);
                bw.append(cast.name + d + cast.address + d + cast.phoneNumber + d + cast.description + d + cast.rating + d + cast.basePricePerNight + d + cast.maxOccupants + d
                        + cast.numberOfBedrooms + d + cast.tinyHome + d + cast.petFriendly + "\r\n");
                System.out.println(cast.name + " written to file.");
            }
        }
        bw.close();
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
