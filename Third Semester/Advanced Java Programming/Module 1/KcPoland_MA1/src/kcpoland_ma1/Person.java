package kcpoland_ma1;


public class Person {
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
        loginName = "Default Username";
        password = "Default Password";
    }
    
    //Overloaded Constructor
    Person(String name, String address, String phoneNumber, String loginName, String password) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.loginName = loginName;
        this.password = password;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        return ("\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nLogin Name: " + loginName + "\nPassword: " + password);
    }
}
