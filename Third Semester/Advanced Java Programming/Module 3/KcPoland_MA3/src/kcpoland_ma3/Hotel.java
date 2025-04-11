package kcpoland_ma3;


public class Hotel extends Lodging {
    //Member Variables//
    //All Hotels have records of current Vacancies, amount of Smoking Rooms, Parking Fees, Valet Parking service flag, Bar amenity flag, Pool amenity flag, and a Free Breakfast flag.
    int vacancies;
    int smokingRooms;
    float parkingFee;
    boolean valetParking;
    boolean bar;
    boolean pool;
    boolean hasFreeBreakfast;
    
    
    //Constructors//
    
    //Default Constructor
    Hotel() {
        vacancies = 0;
        smokingRooms = 0;
        parkingFee = 0.00f;
        valetParking = false;
        bar = false;
        pool = false;
        hasFreeBreakfast = false;
    }
    
    //Overloaded Constructor
    Hotel(String name, String address, String phoneNumber, String description, float rating, float basePricePerNight, 
            int vacancies, int smokingRooms, float parkingFee, boolean valetParking, boolean bar, boolean pool, boolean hasFreeBreakfast) {
        super(name, address, phoneNumber, description, rating, basePricePerNight);
        this.vacancies = vacancies;
        this.smokingRooms = smokingRooms;
        this.parkingFee = parkingFee;
        this.valetParking = valetParking;
        this.bar = bar;
        this.pool = pool;
        this.hasFreeBreakfast = hasFreeBreakfast;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        String superString = super.toString();
        return (superString + "\nHotel Vacancies: " + vacancies + "\nHotel Smoking Rooms: " + smokingRooms + "\nHotel Parking Fee: $" + String.format("%.2f", parkingFee) + "\nValet Parking: " + valetParking + "\nHotel Bar: " + bar + "\nHotel Pool: " + pool + "\nFree Breakfast: " + hasFreeBreakfast);
    }
}
