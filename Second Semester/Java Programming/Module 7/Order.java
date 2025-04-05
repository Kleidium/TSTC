//Program: Widgets Program
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program is an ordering platform for Pillows-a-Plenty, a custom pillow seller. Discounts are possible for certain order quantities. Shipping is free for orders above $50.00.
//This program allows multiple orders to be placed, and provides a way to view the total sales for the day.
//This is the Order class file.

public class Order {
    //Private Data Fields//

	//Integers
    private int smalls;
	private int mediums;
	private int larges;

	//Doubles
	private double total;

    //Public Functions//

    //Sets number of smalls ordered.
    public void setSmalls(int num) {
        this.smalls = num;
    }

    //Retrieves number of smalls ordered.
    public int getSmalls() {
        return smalls;
    }

    //Sets number of mediums ordered.
    public void setMediums(int num) {
        this.mediums = num;
    }

    //Retrieves number of mediums ordered.
    public int getMediums() {
        return mediums;
    }

    //Sets number of larges ordered.
    public void setLarges(int num) {
        this.larges = num;
    }

    //Retrieves number of larges ordered.
    public int getLarges() {
        return larges;
    }

    //Sets final total of order.
    public void setTotal(double num) {
        this.total = num;
    }

    //Retrieves final total of order.
    public double getTotal() {
        return total;
    }
}