package kcpoland_ma2;


public abstract class State {
    //Member Variables//
    static State login, customerView, employeeView, managerView, current;
    
    //Abstract Methods//
    abstract void enter();
    
    abstract void update();
    
}