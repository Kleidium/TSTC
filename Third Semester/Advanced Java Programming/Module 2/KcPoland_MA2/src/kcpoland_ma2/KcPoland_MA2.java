//Program: KcPoland_MA2.java
//Course: INEW-2338-7P1: Module 2
//Author: Kc Poland
//Description: This program is a continuation of the Punching Parrot Travel Agency program. This time, a polymorphic state machine is set up in the form of different menus and interfaces. This is the main program file.



package kcpoland_ma2;


public class KcPoland_MA2 {

    public static void main(String[] args) {
        //Objects//
        
        //States
        State.login = new Login();
        State.employeeView = new EmployeeView();
        State.managerView = new ManagerView();
        State.customerView = new CustomerView();
        State.current = State.login;
        
        //Preloaded Employees
        Person manager = new TravelAgencyEmployee("Manager Smith", "2000 Manager Road", "321-654-0987", "Manager", "password", 2000, 521.00f, true, "01/01/19");
        Person employee = new TravelAgencyEmployee("Employee Davis", "1000 Employee Street", "123-456-7890", "Employee", "password", 1000, 212.00f, false, "10/10/21");
        Registry.userlist.add(employee);
        Registry.userlist.add(manager);
        
        //Preloaded Lodges
        Hotel laQuinta = new Hotel("La Quinta", "3421 La Cienaga Blvd", "956-646-5545", "Beautiful view of the gulf.", 3.7f, 65.99f, 
        12, 1, 0.00f, false, true, true, true);
        House funHouse = new House("The Fun House", "1547 Far Lane", "230-646-1656", "Custom made house built to accomodate parents and their children.", 4.1f, 70.00f, 
        8, 4, false, true);
        Registry.lodgings.add(laQuinta);
        Registry.lodgings.add(funHouse);
        
        
        //Welcome Message//
        System.out.println("\nWelcome to the Punching Parrot Travel Agency program.");
        
        
        //Program Loop//
        while (true) {
            State.current.enter();
            State.current.update();
        }
    }
    
}