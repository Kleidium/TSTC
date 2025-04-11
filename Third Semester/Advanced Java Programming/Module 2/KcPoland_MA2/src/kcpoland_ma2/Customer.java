package kcpoland_ma2;


public class Customer extends Person {
    //Member Variables//
    //Customers should have a record of their unpaid balance and total spending.
    float totalSpending;
    float balanceOwed;
    
    
    //Constructors//
    
    //Default Constructor
    Customer() {
        totalSpending = 0.00f;
        balanceOwed = 0.00f;
    }
    
    //Overloaded Constructors
    Customer(String name, String address, String phoneNumber, String loginName, String password, float totalSpending, float balanceOwed) {
        super(name, address, phoneNumber, loginName, password);
        this.totalSpending = totalSpending;
        this.balanceOwed = balanceOwed;
    }
    
    Customer(String name, String loginName, String password) {
        super(name, loginName, password);
        this.totalSpending = 0.00f;
        this.balanceOwed = 0.00f;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        String superString = super.toString();
        return (superString + "\nTotal Spending: $" + String.format("%.2f", totalSpending) + "\nBalance Owed: $" + String.format("%.2f", balanceOwed));
    }
}
