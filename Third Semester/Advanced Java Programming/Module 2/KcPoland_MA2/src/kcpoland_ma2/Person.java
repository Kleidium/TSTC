package kcpoland_ma2;


public abstract class Person {
    //Member Variables//
    //All Person objects using the program should have a Name, Address, Phone Number, and Login info.
    String name;
    String address;
    String phoneNumber;
    String loginName;
    String password;

    
    //Constructors//
    
    //Default Constructor
    Person() {
        name = "Default Name";
        address = "Default Address";
        phoneNumber = "000-000-0000";
        loginName = "username";
        password = "password";
    }
    
    //Overloaded Constructors
    Person(String name, String address, String phoneNumber, String loginName, String password) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.loginName = loginName;
        this.password = password;
    }
    
    Person(String name, String loginName, String password) {
        this.name = name;
        this.address = "Default Address";
        this.phoneNumber = "000-000-0000";
        this.loginName = loginName;
        this.password = password;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        return ("\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nLogin Name: " + loginName + "\nPassword: " + password);
    }
}
