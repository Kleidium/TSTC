package kcpoland_ma2;


public class TravelAgencyEmployee extends Person {
    //Member Variables//
    //All Employees have an ID Number, Salary info, Manager Status flag, and Hire Date.
    int idNumber;
    float salary;
    boolean isAManager;
    String hireDate;
    
    
    //Constructors//
    
    //Default Constructor
    TravelAgencyEmployee() {
        idNumber = 0000;
        salary = 0.00f;
        isAManager = false;
        hireDate = "01/01/00";
    }
    
    //Overloaded Constructors
    TravelAgencyEmployee(String name, String address, String phoneNumber, String loginName, String password, int idNumber, float salary, boolean isAManager, String hireDate) {
        super(name, address, phoneNumber, loginName, password);
        this.idNumber = idNumber;
        this.salary = salary;
        this.isAManager = isAManager;
        this.hireDate = hireDate;
    }
    
    TravelAgencyEmployee(String name, String loginName, String password) {
        super(name, loginName, password);
        this.idNumber = 0000;
        this.salary = 0.00f;
        this.isAManager = false;
        this.hireDate = "01/01/00";
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        String superString = super.toString();
        return (superString + "\nEmployee ID Number: " + idNumber + "\nEmployee Salary: $" + String.format("%.2f", salary) + " weekly\nEmployee Manager Status: " + isAManager + "\nEmployee Hire Date: " + hireDate);
    }
}
