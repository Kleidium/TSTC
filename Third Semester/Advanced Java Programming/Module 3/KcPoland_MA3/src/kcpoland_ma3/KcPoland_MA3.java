//Program: KcPoland_MA3.java
//Course: INEW-2338-7P1: Module 3
//Author: Kc Poland
//Description: This program is a continuation of the Punching Parrot Travel Agency program. This time, data will be written to and read from files instead of stored in memory only.
//The data used can also now be edited within the appropriate menus.


package kcpoland_ma3;


public class KcPoland_MA3 {

    public static void main(String[] args) {
        //Objects//

        //States
        State.login = new Login();
        State.employeeView = new EmployeeView();
        State.managerView = new ManagerView();
        State.customerView = new CustomerView();
        State.current = State.login;

        
        //Welcome Message//
        System.out.println("\nWelcome to the Punching Parrot Travel Agency program.");

        //Program Loop//
        while (true) {
            State.current.enter();
            State.current.update();
        }
    }
}
