package com.yearup.dealership;

public class SalesContract extends  Contract{
    protected double salePrice;
    protected int loanTerm; // in months
/*
    // Constants for fees and rates
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100;
    private static final double PROCESSING_FEE_UNDER_10000 = 295;
    private static final double PROCESSING_FEE_OVER_10000 = 495;
    private static final double FINANCE_RATE_UNDER_10000 = 0.0525; // 5.25% private static final double FINANCE_RATE_OVER_10000 = 0.0425; // 4.25% private static final int FINANCE_TERM_UNDER_10000 = 24;
    private static final int FINANCE_TERM_OVER_10000 = 48;

 */


    public SalesContract(String date, String customerName, String customerEmail,
                    double vehicleSold, double salePrice, int loanTerm ) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salePrice = salePrice;
        this.loanTerm = loanTerm;

    }
    @Override
    public double getTotalPrice(){
        return salePrice;
    }
    @Override
    public double getMonthlyPayment(){
        // Assuming simple interest
        double interestRate = 0.05; //5% interest
        double monthlyInterestRate = interestRate /12;
        double totalLoanAmount = salePrice*(1+interestRate);
        return totalLoanAmount/loanTerm;
    }

}
