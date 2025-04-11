package kcpoland_ma3;


public class House extends Lodging {
    //Member Variables//
    //All Houses have a record of Maximum Occupancy, Number of Bedrooms, Tiny Home status flag, and a Pet Friendly status flag.
    int maxOccupants;
    int numberOfBedrooms;
    boolean tinyHome;
    boolean petFriendly;
    
    
    //Constructors//
    
    //Default Constructor
    House() {
        maxOccupants = 0;
        numberOfBedrooms = 0;
        tinyHome = false;
        petFriendly = false;
    }
    
    //Overloaded Constructor
    House(String name, String address, String phoneNumber, String description, float rating, float basePricePerNight, int maxOccupants, int numberOfBedrooms, boolean tinyHome, boolean petFriendly) {
        super(name, address, phoneNumber, description, rating, basePricePerNight);
        this.maxOccupants = maxOccupants;
        this.numberOfBedrooms = numberOfBedrooms;
        this.tinyHome = tinyHome;
        this.petFriendly = petFriendly;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        String superString = super.toString();
        return (superString + "\nMax Occupants: " + maxOccupants + "\nNumber of Bedrooms: " + numberOfBedrooms + "\nTiny Home: " + tinyHome + "\nPet Friendly: " + petFriendly);
    }
}
