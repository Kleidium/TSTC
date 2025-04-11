package kcpoland_ma2;

import java.util.Scanner;


public class Login extends State implements Registry {
    ////Login Menu State////
    
    //Override Methods//
    
    @Override
    void enter() {
        System.out.println("\nPunching Parrot: Login");
    }

    @Override
    void update() {
        //Declarations//
        Scanner input = new Scanner(System.in);
        String name = "";
        String username = "";
        String password = "";
        boolean valid = false;

        while (true) {
            //Menu//
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Continue as Guest");
            System.out.println("4. Exit");
            
            //Input
            System.out.print("\nSelect an option: ");
            String choice = input.nextLine();

            switch (choice) {
                //Login//
                case "1":
                    //Username Prompt
                    System.out.print("\nPlease enter your username: ");
                    username = input.nextLine();

                    //Password Prompt
                    System.out.print("\nPlease enter your password: ");
                    password = input.nextLine();
                    
                    //Check Registry
                    for ( int i = 0; i < userlist.size(); i++) {
                        //Check Username
                        if (userlist.get(i).loginName.equals(username)) {
                            //Check Password
                            if (userlist.get(i).password.equals(password)) {
                                //Login Success
                                System.out.println("\nWelcome, " + userlist.get(i).name + ".");
                                
                                //Employee or Customer?
                                if (userlist.get(i) instanceof TravelAgencyEmployee) {
                                    //Employee Login
                                    TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                                    if (employeeCast.isAManager) {
                                        //Manager Access
                                        current = managerView;
                                    } else {
                                        //Employee Access
                                        EmployeeView stateCast = (EmployeeView) employeeView;
                                        stateCast.managerLogin = false;
                                        current = stateCast;
                                    }
                                } else {
                                    //Customer Login
                                    current = customerView;
                                }
                                break;
                            } else {
                                //Invalid Password
                                System.out.println("\nInvalid Password. Please try again.");
                            }
                        } else if (i == (userlist.size() - 1)){
                            //Invalid Username
                            System.out.println("\nInvalid Username. Please try again.");
                        }
                    }
                    return;
                //Register//
                case "2":
                    //Prompt for Name
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter your name: ");
                        name = input.nextLine();
                        
                        //Validate
                        if (name.length() > 0){
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter your name.");
                        }
                    }
                    
                    //Prompt for Username
                    valid = false;
                    while (valid == false) {
                        System.out.println("\nPlease enter your desired username. Usernames cannot contain spaces.");
                        System.out.print("\nDesired Username: ");
                        username = input.nextLine();
                        
                        //Validate//
                        if (username.length() > 0){
                            //Check for Spaces
                            if (username.contains(" ")) {
                                System.out.println("Invalid input. Usernames cannot contain spaces.");
                            } else {
                                //Check for Duplicates
                                valid = true;
                                for ( int i = 0; i < userlist.size(); i++) {
                                    if (userlist.get(i).loginName.equals(username)) {
                                        System.out.println("Username already in use. Please try a different username.");
                                        valid = false;
                                        break;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a username.");
                        }
                    }
                    
                    //Prompt for Password
                    valid = false;
                    while (valid == false) {
                        System.out.println("\nPlease enter your desired password.");
                        System.out.println("Passwords cannot contain spaces and require at least 1 capital letter and 1 special character, and are at least 8 characters long.");
                        System.out.print("\nDesired Password: ");
                        password = input.nextLine();
                        
                        //Validate//
                        if (password.length() >= 8){
                            //Check for Spaces
                            if (password.contains(" ")) {
                                System.out.println("Invalid input. Passwords cannot contain spaces.");
                            } else {
                                //Check for Capital Letter
                                boolean containsCapital = false;
                                for (int index = 0; index < password.length(); index++) {
                                    if (Character.isUpperCase(password.charAt(index))){
                                        containsCapital = true;
                                        break;
                                    }
                                }
                                //Check for Special Character
                                boolean containsSpecial = false;
                                for (int index = 0; index < password.length(); index++) {
                                    if (Character.isLetter(password.charAt(index)) == false && Character.isDigit(password.charAt(index)) == false){
                                        containsSpecial = true;
                                        break;
                                    }
                                }
                                //Determine Validity
                                if (containsCapital && containsSpecial){
                                    valid = true;
                                    Customer newCustomer = new Customer(name, username, password);
                                    userlist.add(newCustomer);
                                    System.out.println("Account Created.");
                                } else {
                                    System.out.println("Invalid input. Passwords must contain at least 1 capital letter and 1 special character.");
                                }
                            }
                        } else {
                            System.out.println("Invalid input. Password must be at least 8 characters.");
                        }
                    }
                    return;
                //Continue as Guest//
                case "3":
                    current = customerView;
                    return;
                //Exit//
                case "4":
                    System.out.println("\nExiting program...");
                    System.exit(0);
                //Invalid Selection//
                default:
                    System.out.println("Invalid selection. Please select a number from the menu.");
            }
        }
    }
}
