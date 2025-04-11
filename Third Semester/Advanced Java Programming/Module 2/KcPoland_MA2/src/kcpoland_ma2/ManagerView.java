package kcpoland_ma2;

import java.util.Scanner;


public class ManagerView extends State implements Registry {
    ////Manager Menu State////
    
    //Override Methods//
    
    @Override
    void enter() {
        System.out.println("\nPunching Parrot: Manager View");
    }
    
    @Override
    void update() {
        //Declarations//
        
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String name = "";
        String address = "";
        String phone = "";
        String username = "";
        String password = "";
        String idString = "";
        int idNumber = 0000;
        String salaryString = "";
        float salary = 0.00f;
        String isAManager = "";
        boolean managerStatus = false;
        String hireDate = "";
        
        while (true){
            //Menu//
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. List Employees");
            System.out.println("4. Promote Employee");
            System.out.println("5. Manage Lodges");
            System.out.println("6. Log Out");
            
            //Input
            System.out.print("\nSelect an option: ");
            String choice = input.nextLine();
            
            switch (choice) {
                //Add Employee//
                case "1":
                    //Prompt for Name
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Employee Name: ");
                        name = input.nextLine();
                        
                        //Validate
                        if (name.length() > 0){
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the employee's name.");
                        }
                    }
                    
                    //Prompt for Address
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Employee Address: ");
                        address = input.nextLine();
                        
                        //Validate
                        if (address.length() > 0){
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the employee's address.");
                        }
                    }
                    
                    //Prompt for Phone Number
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Employee Phone Number: ");
                        phone = input.nextLine();
                        
                        //Validate
                        if (phone.length() > 0){
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the employee's phone number.");
                        }
                    }
                    
                    //Prompt for Username
                    valid = false;
                    while (valid == false) {
                        System.out.println("\nPlease enter employee's desired username. Usernames cannot contain spaces.");
                        System.out.print("\nDesired Username: ");
                        username = input.nextLine();
                        
                        //Validate
                        if (username.length() > 0){
                            if (username.contains(" ")) {
                                System.out.println("Invalid input. Usernames cannot contain spaces.");
                            } else {
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
                    
                    //Prompt for Password. No validation required.
                    System.out.println("\nPlease enter the employee's new password.");
                    System.out.print("\nNew Password: ");
                    password = input.nextLine();
                    
                    //Prompt for ID Number
                    valid = false;
                    while (valid == false) {
                        System.out.println("\nPlease enter employee's new ID Number.");
                        System.out.print("\nNew ID Number: ");
                        idString = input.nextLine();
                        
                        //Validate
                        if (idString.length() > 0){
                            valid = true;
                            idNumber = Integer.parseInt(idString);
                            for ( int i = 0; i < userlist.size(); i++) {
                                if (userlist.get(i) instanceof TravelAgencyEmployee) {
                                    TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                                    if (Integer.toString(employeeCast.idNumber).equals(idString)) {
                                        System.out.println("ID Number already in use. Please try a different ID Number.");
                                        valid = false;
                                        break;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid input. Please enter an ID Number.");
                        }
                    }
                    
                    //Salary Prompt
                    valid = false;
                    while (valid == false) {
                        System.out.println("\nPlease enter employee's new weekly Salary.");
                        System.out.print("\nNew Salary: ");
                        salaryString = input.nextLine();
                        
                        //Validate
                        if (salaryString.length() > 0){
                            valid = true;
                            salary = Float.parseFloat(salaryString);
                        } else {
                            System.out.println("Invalid input. Please enter the employee's weekly salary.");
                        }
                    }
                    
                    //Manager Status Prompt
                    valid = false;
                    while (valid == false) {
                        System.out.println("\nIs this employee a manager?");
                        System.out.println("\n1. Yes");
                        System.out.println("2. No");
                        System.out.print("\nAnswer: ");
                        isAManager = input.nextLine();
                        
                        //Validate
                        switch (isAManager) {
                            case "1":
                                valid = true;
                                managerStatus = true;
                                break;
                            case "2":
                                valid = true;
                                managerStatus = false;
                                break;
                            default:
                                System.out.println("Invalid selection. Please select a number from the menu.");
                        }
                    }
                    
                    //Hire Date Prompt
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Employee Hire Date: ");
                        hireDate = input.nextLine();
                        
                        //Validate
                        if (hireDate.length() > 0){
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the employee's hire date.");
                        }
                    }
                    
                    //Add to Userlist
                    TravelAgencyEmployee newEmployee = new TravelAgencyEmployee(name, address, phone, username, password, idNumber, salary, managerStatus, hireDate);
                    userlist.add(newEmployee);
                    System.out.println("Employee added to system.");
                    return;
                //Remove Employee//
                case "2":
                    //Display Employees
                    System.out.println("\n\tEmployees by ID and Name: \n");
                    
                    for ( int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                        }
                    }
                    
                    //Input
                    System.out.print("\nSelect an employee to remove by their ID Number: ");
                    String selection = input.nextLine();
                    
                    //Confirmation and Removal
                    for ( int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            if (Integer.toString(employeeCast.idNumber).equals(selection)) {
                                System.out.println("\nRemove this employee?\n");
                                System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                                System.out.println("\n1. Yes");
                                System.out.println("2. No");
                                
                                System.out.print("\nSelect an option: ");
                                selection = input.nextLine();

                                switch (selection) {
                                    //Remove Employee
                                    case "1":
                                        userlist.remove(i);
                                        System.out.println("\nEmployee removed from list.");
                                        break;
                                    //Keep Employee
                                    case "2":
                                        break;
                                    //Invalid Selection
                                    default:
                                        System.out.println("Invalid selection. Please select a number from the menu.");
                                }
                                break;
                            } else if (i == (userlist.size() - 1)) {
                                //Invalid Selection
                                System.out.println("\nInvalid ID. Please try again.");
                            }
                        }
                    }
                    return;
                //List Employees//
                case "3":
                    //Display Employees
                    System.out.println("\n\tEmployees by ID and Name: \n");
                    
                    for ( int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                        }
                    }
                    
                    //Input
                    System.out.print("\nSelect an employee ID Number: ");
                    selection = input.nextLine();
                    
                    //Show Information
                    for ( int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            if (Integer.toString(employeeCast.idNumber).equals(selection)) {
                                System.out.println("\n\tInfo for Employee #" + selection);
                                System.out.println(employeeCast.toString());
                                break;
                            } else if (i == (userlist.size() - 1)) {
                                //Invalid Selection
                                System.out.println("\nInvalid ID. Please try again.");
                            }
                        }
                    }
                    return;
                //Promote Employees//
                case "4":
                    //Display Employees
                    System.out.println("\n\tEmployees by ID and Name: \n");
                    
                    for ( int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                        }
                    }
                    
                    //Input
                    System.out.print("\nSelect an employee to promote by their ID Number: ");
                    selection = input.nextLine();
                    
                    //Confirmation and Promotion
                    for ( int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            if (Integer.toString(employeeCast.idNumber).equals(selection)) {
                                System.out.println("\nPromote this employee?\n");
                                System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                                System.out.println("\n1. Yes");
                                System.out.println("2. No");

                                System.out.print("\nSelect an option: ");
                                selection = input.nextLine();

                                switch (selection) {
                                    //Promote Employee
                                    case "1":
                                        if (employeeCast.isAManager) {
                                            System.out.println("\nEmployee is already a manager.");
                                        } else {
                                            employeeCast.isAManager = true;
                                            System.out.println("\nEmployee promoted.");
                                        }
                                        break;
                                    //Keep Employee Unchanged
                                    case "2":
                                        System.out.println("\nNo action taken.");
                                        break;
                                    //Invalid Selection
                                    default:
                                        System.out.println("Invalid selection. Please select a number from the menu.");
                                }
                                break;
                            } else if (i == (userlist.size() - 1)) {
                                //Invalid Selection
                                System.out.println("\nInvalid ID. Please try again.");
                            }
                        }
                    }
                    return;
                //Manage Lodgings//
                case "5":
                    EmployeeView stateCast = (EmployeeView) employeeView;
                    stateCast.managerLogin = true;
                    current = stateCast;
                    return;
                //Log Out//
                case "6":
                    current = login;
                    return;
                //Invalid Selection//
                default:
                    System.out.println("Invalid selection. Please select a number from the menu.");
            }
        }
    }
    
}