package kcpoland_ma2;


public class HotelRoom {
    //Member Variables//
    //All Hotel Rooms have a Room Number, Number of Beds, and Max Occupancy records. Base Price per Night is governed by the Hotel/Lodging.
    int roomNumber;
    int numberOfBeds;
    int maxOccupants;
    
    
    //Constructors//
    
    //Default Constructor
    HotelRoom() {
        roomNumber = 0;
        numberOfBeds = 0;
        maxOccupants = 0;
    }
    
    //Overloaded Constructor
    HotelRoom(int roomNumber, int numberOfBeds, int maxOccupants) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.maxOccupants = maxOccupants;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        return ("\nRoom Number: " + roomNumber + "\nNumber of Beds: " + numberOfBeds + "\nMax Occupants: " + maxOccupants);
    }
}
