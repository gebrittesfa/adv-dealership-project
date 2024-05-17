package com.yearup.dealership;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private double vehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    // Constructor


    public Contract(String date, String customerName, String customerEmail,
                    double vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
       }

    @Override
    public String toString() {
        return "Contract{" +
                "date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", vehicleSold=" + vehicleSold +
                ", totalPrice=" + totalPrice +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
    //Getters and Setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(double vehicleSold) {
        this.vehicleSold = vehicleSold;
    }


    // Abstract methods to calculate total price and monthly payment
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

}
