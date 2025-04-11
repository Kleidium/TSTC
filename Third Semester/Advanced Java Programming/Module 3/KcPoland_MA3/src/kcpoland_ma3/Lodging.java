package kcpoland_ma3;


public abstract class Lodging {
    //Member Variables//
    //All Lodging objects have a Name, Address, Phone Number, Description of Lodging, Rating, and Base Price per Night.
    String name;
    String address;
    String phoneNumber;
    String description;
    float rating;
    float basePricePerNight;
    
    
    //Constructors//
    
    //Default Constructor
    Lodging() {
        name = "Lodging Name";
        phoneNumber = "000-000-0000";
        address = "Lodging Address";
        description = "Lodging Description";
        rating = 0.0f;
        basePricePerNight = 0.00f;
    }
    
    //Overloaded Constructor
    Lodging(String name, String address, String phoneNumber, String description, float rating, float basePricePerNight) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.rating = rating;
        this.basePricePerNight = basePricePerNight;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        return ("\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nDescription: " + description + "\nRating: " + rating + 
                "\nBase Price Per Night: $" + String.format("%.2f", basePricePerNight));
    }
}