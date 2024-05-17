package com.yearup.dealership;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;
    // Constants for lease terms
    private static final double LEASE_FEE_RATE = 0.07; // 7%
    private static final double FINANCE_RATE = 0.04; // 4.0%
    private static final int LEASE_TERM = 36; // 36 months
    public LeaseContract(String date, String customerName, String customerEmail,
                         double vehicleSold, double expectedEndingValue) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = expectedEndingValue * LEASE_FEE_RATE;
    }
    //Getters and Setters


    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
    //@Override getTotalPrice to include lease fee
     @Override
    public double getTotalPrice() {
        return expectedEndingValue + leaseFee;
    }
    // Override getMonthlyPayment for lease contracts @Override
    public double getMonthlyPayment() {
        double totalLoanAmount = expectedEndingValue;
        double monthlyInterestRate = FINANCE_RATE / 12;
        return totalLoanAmount * (monthlyInterestRate / (1 - Math.pow(1
                + monthlyInterestRate, -LEASE_TERM)));
    }

}
