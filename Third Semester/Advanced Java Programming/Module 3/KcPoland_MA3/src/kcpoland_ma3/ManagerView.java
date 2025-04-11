package kcpoland_ma3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManagerView extends State implements Registry {
    ////Manager Menu State////

    //State Methods//
    @Override
    void enter() {
        //Load Userlist
        try {
            this.load();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
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

        while (true) {
            //Menu//
            System.out.println("1. Add Employees");
            System.out.println("2. Remove Employees");
            System.out.println("3. List Employees");
            System.out.println("4. Promote Employees");
            System.out.println("5. Edit Employees");
            System.out.println("6. Manage Lodges");
            System.out.println("7. Log Out");

            //Input
            System.out.print("\nSelect an option: ");
            String choice = input.nextLine();

            switch (choice) {
                //Add Employees//
                case "1":
                    //Prompt for Name
                    valid = false;
                    while (valid == false) {
                        System.out.print("\nPlease enter Employee Name: ");
                        name = input.nextLine();

                        //Validate
                        if (name.length() > 0) {
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
                        if (address.length() > 0) {
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
                        if (phone.length() > 0) {
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
                        if (username.length() > 0) {
                            if (username.contains(" ")) {
                                System.out.println("Invalid input. Usernames cannot contain spaces.");
                            } else {
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
                        if (idString.length() > 0) {
                            valid = true;
                            try {
                                idNumber = Integer.parseInt(idString);
                            } catch (Exception e) {
                                valid = false;
                                System.out.println("Invalid input. Input must be a whole number.");
                            }
                            for (int i = 0; i < userlist.size(); i++) {
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
                        if (salaryString.length() > 0) {
                            valid = true;
                            try {
                                salary = Float.parseFloat(salaryString);
                            } catch (Exception e) {
                                valid = false;
                                System.out.println("Invalid input. Input must be a number.");
                            }
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
                        if (hireDate.length() > 0) {
                            valid = true;
                        } else {
                            System.out.println("Invalid input. Please enter the employee's hire date.");
                        }
                    }

                    //Add to Userlist
                    TravelAgencyEmployee newEmployee = new TravelAgencyEmployee(name, address, phone, username, password, idNumber, salary, managerStatus, hireDate);
                    userlist.add(newEmployee);
                    try {
                        save();
                    } catch (Exception e) {
                        System.out.println("Message: " + e);
                    }
                    System.out.println("Employee added to system.");
                    return;
                //Remove Employees//
                case "2":
                    //Display Employees
                    System.out.println("\n\tEmployees by ID and Name: \n");

                    for (int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                        }
                    }

                    //Input
                    System.out.print("\nSelect an employee to remove by their ID Number: ");
                    String selection = input.nextLine();

                    //Confirmation and Removal
                    for (int i = 0; i < userlist.size(); i++) {
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
                                        try {
                                            save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
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

                    for (int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                        }
                    }

                    //Input
                    System.out.print("\nSelect an employee ID Number: ");
                    selection = input.nextLine();

                    //Show Information
                    for (int i = 0; i < userlist.size(); i++) {
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

                    for (int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                        }
                    }

                    //Input
                    System.out.print("\nSelect an employee to promote by their ID Number: ");
                    selection = input.nextLine();

                    //Confirmation and Promotion
                    for (int i = 0; i < userlist.size(); i++) {
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
                                            try {
                                                save();
                                            } catch (Exception e) {
                                                System.out.println("Message: " + e);
                                            }
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
                //Edit Employees//
                case "5":
                    //Display Employees
                    System.out.println("\n\tEmployees by ID and Name: \n");

                    for (int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            System.out.println(employeeCast.idNumber + ". " + userlist.get(i).name);
                        }
                    }

                    //Input
                    System.out.print("\nSelect an employee to edit by their ID Number: ");
                    selection = input.nextLine();

                    //Editing Menu
                    for (int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i) instanceof TravelAgencyEmployee) {
                            TravelAgencyEmployee employeeCast = (TravelAgencyEmployee) userlist.get(i);
                            if (Integer.toString(employeeCast.idNumber).equals(selection)) {
                                System.out.println("\n\tEdit this employee?");
                                System.out.println(employeeCast.toString());
                                System.out.println("\n1. Edit Name");
                                System.out.println("2. Edit Address");
                                System.out.println("3. Edit Phone Number");
                                System.out.println("4. Edit Username");
                                System.out.println("5. Edit Password");
                                System.out.println("6. Edit ID Number");
                                System.out.println("7. Edit Salary");
                                System.out.println("8. Edit Manager Status");
                                System.out.println("9. Edit Hire Date");
                                System.out.println("10. Cancel");

                                System.out.print("\nSelect an option: ");
                                selection = input.nextLine();

                                switch (selection) {
                                    //Edit Name
                                    case "1":
                                        //Prompt for Name
                                        valid = false;
                                        while (valid == false) {
                                            System.out.print("\nPlease enter new Employee Name: ");
                                            name = input.nextLine();

                                            //Validate
                                            if (name.length() > 0) {
                                                valid = true;
                                            } else {
                                                System.out.println("Invalid input. Please enter the employee's name.");
                                            }
                                        }
                                        
                                        //Update
                                        employeeCast.name = name;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee name updated.");
                                        break;
                                    //Edit Address
                                    case "2":
                                        //Prompt for Address
                                        valid = false;
                                        while (valid == false) {
                                            System.out.print("\nPlease enter new Employee Address: ");
                                            address = input.nextLine();

                                            //Validate
                                            if (address.length() > 0) {
                                                valid = true;
                                            } else {
                                                System.out.println("Invalid input. Please enter the employee's address.");
                                            }
                                        }
                                        
                                        //Update
                                        employeeCast.address = address;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee address updated.");
                                        break;
                                    //Edit Phone Number
                                    case "3":
                                        //Prompt for Phone Number
                                        valid = false;
                                        while (valid == false) {
                                            System.out.print("\nPlease enter new Employee Phone Number: ");
                                            phone = input.nextLine();

                                            //Validate
                                            if (phone.length() > 0) {
                                                valid = true;
                                            } else {
                                                System.out.println("Invalid input. Please enter the employee's phone number.");
                                            }
                                        }
                                        
                                        //Update
                                        employeeCast.phoneNumber = phone;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee phone number updated.");
                                        break;
                                    //Edit Username
                                    case "4":
                                        //Prompt for Username
                                        valid = false;
                                        while (valid == false) {
                                            System.out.println("\nPlease enter employee's new username. Usernames cannot contain spaces.");
                                            System.out.print("\nDesired Username: ");
                                            username = input.nextLine();

                                            //Validate
                                            if (username.length() > 0) {
                                                if (username.contains(" ")) {
                                                    System.out.println("Invalid input. Usernames cannot contain spaces.");
                                                } else {
                                                    valid = true;
                                                    for (int n = 0; n < userlist.size(); n++) {
                                                        if (userlist.get(n).loginName.equals(username)) {
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
                                        
                                        //Update
                                        employeeCast.loginName = username;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee username updated.");
                                        break;
                                    //Edit Password
                                    case "5":
                                        //Prompt for Password. No validation required.
                                        System.out.println("\nPlease enter the employee's new password.");
                                        System.out.print("\nNew Password: ");
                                        password = input.nextLine();
                                        
                                        //Update
                                        employeeCast.password = password;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee password updated.");
                                        break;
                                    //Edit ID Number
                                    case "6":
                                        //Prompt for ID Number
                                        valid = false;
                                        while (valid == false) {
                                            System.out.println("\nPlease enter employee's new ID Number.");
                                            System.out.print("\nNew ID Number: ");
                                            idString = input.nextLine();

                                            //Validate
                                            if (idString.length() > 0) {
                                                valid = true;
                                                try {
                                                    idNumber = Integer.parseInt(idString);
                                                } catch (Exception e) {
                                                    valid = false;
                                                    System.out.println("Invalid input. Input must be a whole number.");
                                                }
                                                for (int n = 0; n < userlist.size(); n++) {
                                                    if (userlist.get(n) instanceof TravelAgencyEmployee) {
                                                        TravelAgencyEmployee tempCast = (TravelAgencyEmployee) userlist.get(n);
                                                        if (Integer.toString(tempCast.idNumber).equals(idString)) {
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
                                        
                                        //Update
                                        employeeCast.idNumber = idNumber;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee ID number updated.");
                                        break;
                                    //Edit Salary
                                    case "7":
                                        //Salary Prompt
                                        valid = false;
                                        while (valid == false) {
                                            System.out.println("\nPlease enter employee's new weekly Salary.");
                                            System.out.print("\nNew Salary: ");
                                            salaryString = input.nextLine();

                                            //Validate
                                            if (salaryString.length() > 0) {
                                                valid = true;
                                                try {
                                                    salary = Float.parseFloat(salaryString);
                                                } catch (Exception e) {
                                                    valid = false;
                                                    System.out.println("Invalid input. Input must be a number.");
                                                }
                                            } else {
                                                System.out.println("Invalid input. Please enter the employee's weekly salary.");
                                            }
                                        }
                                        
                                        //Update
                                        employeeCast.salary = salary;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee salary updated.");
                                        break;
                                    //Edit Manager Status
                                    case "8":
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
                                        
                                        //Update
                                        employeeCast.isAManager = managerStatus;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee manager status updated.");
                                        break;
                                    //Edit Hire Date
                                    case "9":
                                        //Hire Date Prompt
                                        valid = false;
                                        while (valid == false) {
                                            System.out.print("\nPlease enter Employee Hire Date: ");
                                            hireDate = input.nextLine();

                                            //Validate
                                            if (hireDate.length() > 0) {
                                                valid = true;
                                            } else {
                                                System.out.println("Invalid input. Please enter the employee's hire date.");
                                            }
                                        }
                                        
                                        //Update
                                        employeeCast.hireDate = hireDate;
                                        try {
                                            this.save();
                                        } catch (Exception e) {
                                            System.out.println("Message: " + e);
                                        }
                                        System.out.println("\nEmployee hire date updated.");
                                        break;
                                    //Cancel
                                    case "10":
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
                case "6":
                    EmployeeView stateCast = (EmployeeView) employeeView;
                    stateCast.managerLogin = true;
                    current = stateCast;
                    return;
                //Log Out//
                case "7":
                    current = login;
                    return;
                //Invalid Selection//
                default:
                    System.out.println("Invalid selection. Please select a number from the menu.");
            }
        }
    }

    //Registry Methods//
    
    //Save Employees to file
    @Override
    public void save() throws IOException {
        ////Declarations////

        //File Handling
        FileWriter fw = new FileWriter("employees.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        String d = "~";

        //Overwrite Employees
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i) instanceof TravelAgencyEmployee) {
                TravelAgencyEmployee cast = (TravelAgencyEmployee) userlist.get(i);
                bw.append(cast.name + d + cast.address + d + cast.phoneNumber + d + cast.loginName + d + Login.encrypt(cast.password) + d + cast.idNumber + d + cast.salary + d + cast.isAManager + d + cast.hireDate + "\r\n");
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
            password = Login.decrypt(array[4]);
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
            password = Login.decrypt(array[4]);
            totalSpending = Float.parseFloat(array[5]);
            balanceOwed = Float.parseFloat(array[6]);

            Customer user = new Customer(name, address, phone, username, password, totalSpending, balanceOwed);
            userlist.add(user);
            s = br.readLine();
        }
        br.close();
    }
}
