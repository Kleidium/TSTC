package kcpoland_ma3;


public class OrderDetails {
    //Member Variables//
    //Each Order Detail has the Name of Purchaser, Date of Purchase, Transaction ID, Balance Owed, and Order Total.
    private String name;
    private String date;
    private int idNumber;
    private float balanceOwed;
    private float totalSpending;
    
    
    //Constructors//
    
    //Default Constructor
    OrderDetails() {
        name = "Default Name";
        date = "Default Date";
        idNumber = 00000;
        balanceOwed = 0.00f;
        totalSpending = 0.00f;
    }
    
    //Overloaded Constructor
    OrderDetails(String name, String date, int idNumber, float balanceOwed, float totalSpending) {
        this.name = name;
        this.date = date;
        this.idNumber = idNumber;
        this.balanceOwed = balanceOwed;
        this.totalSpending = totalSpending;
    }
    
    
    //Get and Set Methods//
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public float getBalanceOwed() {
        return balanceOwed;
    }

    public void setBalanceOwed(float balanceOwed) {
        this.balanceOwed = balanceOwed;
    }

    public float getTotalSpending() {
        return totalSpending;
    }

    public void setTotalSpending(float totalSpending) {
        this.totalSpending = totalSpending;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        return ("\nCustomer Name: " + name + "\nOrder Date: " + date + "\nOrder ID Number: " + idNumber + "\nBalance Owed: $" + String.format("%.2f", balanceOwed) + "\nTotal Spending: $" + String.format("%.2f", totalSpending));
    }
    
}
