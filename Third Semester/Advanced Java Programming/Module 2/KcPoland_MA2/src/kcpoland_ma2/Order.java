package kcpoland_ma2;


public class Order {
    //Member Variables//
    //All Order objects contain information pertaining to an order that has not yet been placed.
    String lodgingName = "";
    int numberOfNights;
    float pricePerNight;
    
    //Methods//
    
    public String getLodgingName() {
        return lodgingName;
    }

    public void setLodgingName(String lodgingName) {
        this.lodgingName = lodgingName;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
