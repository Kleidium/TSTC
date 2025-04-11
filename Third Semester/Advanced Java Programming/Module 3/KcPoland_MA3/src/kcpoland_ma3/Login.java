package kcpoland_ma3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login extends State implements Registry {
    ////Login Menu State////

    //State Methods//
    @Override
    void enter() {
        //Load Userlist
        try {
            this.load();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
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
                    for (int i = 0; i < userlist.size(); i++) {
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
                        } else if (i == (userlist.size() - 1)) {
                            //Invalid Username
                            System.out.println("\nInvalid username or password. Please try again.");
                        }
                    }
                    return;
                //Register//
                case "2":
                    ////Declarations////

                    //Fields//
                    
                    //Persons
                    String address = "";
                    String phone = "";

                    //Customers
                    float totalSpending = 0.00f;
                    float balanceOwed = 0.00f;

                    //Prompts//
                    
                    //Prompt for Name
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter your name: ");
                        name = input.nextLine();

                        //Validate
                        if (name.length() > 0) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter your name.");
                        }
                    }

                    //Prompt for Address
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter your Address: ");
                        address = input.nextLine();

                        //Validate
                        if (address.length() > 0) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter your address.");
                        }
                    }

                    //Prompt for Phone Number
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter your Phone Number: ");
                        phone = input.nextLine();

                        //Validate
                        if (phone.length() > 0) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter your phone number.");
                        }
                    }

                    //Prompt for Username
                    valid = false;
                    while (valid == false) {
                        System.out.println("\nPlease enter your desired username. Usernames cannot contain spaces.");
                        System.out.print("\nDesired Username: ");
                        username = input.nextLine();

                        //Validate//
                        if (username.length() > 0) {
                            //Check for Spaces
                            if (username.contains(" ")) {
                                System.out.println("Invalid input. Usernames cannot contain spaces.");
                            } else {
                                //Check for Duplicates
                                valid = true;
                                for (int i = 0; i < userlist.size(); i++) {
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
                        if (password.length() >= 8) {
                            //Check for Spaces
                            if (password.contains(" ")) {
                                System.out.println("Invalid input. Passwords cannot contain spaces.");
                            } else {
                                //Check for Capital Letter
                                boolean containsCapital = false;
                                for (int index = 0; index < password.length(); index++) {
                                    if (Character.isUpperCase(password.charAt(index))) {
                                        containsCapital = true;
                                        break;
                                    }
                                }
                                //Check for Special Character
                                boolean containsSpecial = false;
                                for (int index = 0; index < password.length(); index++) {
                                    if (Character.isLetter(password.charAt(index)) == false && Character.isDigit(password.charAt(index)) == false) {
                                        containsSpecial = true;
                                        break;
                                    }
                                }
                                //Determine Validity
                                if (containsCapital && containsSpecial) {
                                    valid = true;
                                    Customer newCustomer = new Customer(name, address, phone, username, password, totalSpending, balanceOwed);
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
                    try {
                        this.save();
                    } catch (Exception e) {
                        System.out.println("Message: " + e);
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

    
    //Registry Methods//
    
    //Save Customers to file
    @Override
    public void save() throws IOException {
        ////Declarations////

        //File Handling
        FileWriter fw = new FileWriter("customers.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        String d = "~";

        //Overwrite Customers
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i) instanceof Customer) {
                Customer cast = (Customer) userlist.get(i);
                bw.append(cast.name + d + cast.address + d + cast.phoneNumber + d + cast.loginName + d + encrypt(cast.password) + d + cast.totalSpending + d + cast.balanceOwed + "\r\n");
            }
        }
        bw.close();
    }

    //Load Userlist
    @Override
    public void load() throws IOException {
        //Declarations//

        //File Handling
        FileReader fr = new FileReader("employees.txt");
        BufferedReader br = new BufferedReader(fr);
        String[] array = new String[9];
        String s = "";
        String delimiter = "~";

        //Fields//
        
        //Persons
        String name;
        String address;
        String phone;
        String username;
        String password;

        //Employees
        int idNum;
        float salary;
        boolean managerStatus;
        String hireDate;

        //Customers
        float totalSpending;
        float balanceOwed;

        //Load Userlist//
        
        //Clear Existing List
        userlist.clear();

        //Add Employees
        s = br.readLine();
        while (s != null) {
            array = s.split(delimiter);
            name = array[0];
            address = array[1];
            phone = array[2];
            username = array[3];
            password = decrypt(array[4]);
            idNum = Integer.parseInt(array[5]);
            salary = Float.parseFloat(array[6]);
            managerStatus = Boolean.parseBoolean(array[7]);
            hireDate = array[8];

            TravelAgencyEmployee user = new TravelAgencyEmployee(name, address, phone, username, password, idNum, salary, managerStatus, hireDate);
            userlist.add(user);
            s = br.readLine();
        }
        br.close();

        //Add Customers
        fr = new FileReader("customers.txt");
        br = new BufferedReader(fr);

        s = br.readLine();
        while (s != null) {
            array = s.split(delimiter);
            name = array[0];
            address = array[1];
            phone = array[2];
            username = array[3];
            password = decrypt(array[4]);
            totalSpending = Float.parseFloat(array[5]);
            balanceOwed = Float.parseFloat(array[6]);

            Customer user = new Customer(name, address, phone, username, password, totalSpending, balanceOwed);
            userlist.add(user);
            s = br.readLine();
        }
        br.close();
    }

    
    //Encryption Methods//
    
    public static String encrypt(String password) {
        String key = "SaIdGkjidfGkKfldsahSfodDFsfdHJDHsadv";

        String encrypted = "";

        if (password.length() > 0) {
            for (int i = 0; i < password.length(); i++) {
                encrypted = encrypted + password.charAt(i) + key;
            }
        } else {
            encrypted = key + key;
        }

        return encrypted;
    }

    public static String decrypt(String password) {
        String key = "SaIdGkjidfGkKfldsahSfodDFsfdHJDHsadv";

        String decrypted = password.replaceAll(key, "");

        return decrypted;
    }
}
