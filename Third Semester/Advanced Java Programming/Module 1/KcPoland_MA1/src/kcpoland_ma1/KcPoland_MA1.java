//Program: KcPoland_MA1.java
//Course: INEW-2338-7P1: Module 1
//Author: Kc Poland
//Description: This program provides test classes to be used in the Punching Parrot Travel Agency program, and provides examples of 5 Lodging objects (Hotels and Houses).



package kcpoland_ma1;


public class KcPoland_MA1 {

    public static void main(String[] args) {
        //Welcome Message//
        System.out.println("Welcome to the Punching Parrot Travel Agency test program.");
        
        
        //Lodging Object Examples//
        System.out.println("\n\nLodging Object Examples:");
        
        //Hotels
        
        Hotel laQuinta = new Hotel("La Quinta", "3421 La Cienaga Blvd", "956-646-5545", "Beautiful view of the gulf.", 3.7f, 65.99f, false, 
                12, 1, 0.00f, false, true, true);
        System.out.println("\n(Hotel 1: La Quinta)" + laQuinta.toString());
        
        Hotel holidayInn = new Hotel("Holiday Inn", "1801 Christmas Street", "325-643-1535", "Great location in the middle of downtown.", 4.1f, 75.50f, true, 
                6, 0, 12.00f, true, false, true);
        System.out.println("\n(Hotel 2: Holiday Inn)" + holidayInn.toString());
        
        Hotel bestWestern = new Hotel("Best Western", "9442 Cowboy Road", "254-641-2347", "Great bar, great view of the river.", 4.5f, 85.00f, true, 
                0, 0, 0.00f, false, true, false);
        System.out.println("\n(Hotel 3: Best Western)" + bestWestern.toString());
        
        //Houses
        
        House funHouse = new House("The Fun House", "1547 Far Lane", "230-646-1656", "Custom made house built to accomodate parents and their children.", 4.1f, 70.00f, 
                8, 4, false, true);
        System.out.println("\n(House 1: The Fun House)" + funHouse.toString());
        
        House newCastle = new House("Newcastle", "5241 Royal Road", "230-643-2158", "Castle-style home with a premium location near the lake.", 5.0f, 370.00f, 
                24, 8, false, false);
        System.out.println("\n(House 2: Newcastle)" + newCastle.toString());
    }
    
}
