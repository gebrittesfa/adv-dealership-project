package com.yearup.dealership;


import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    // Method to save contract data to a contracts file
    private String filename;

    public ContractFileManager(String filename) {
        this.filename = filename;
    }
    public void saveContract(Contract contract) {
        //  String fileName = "contract.csv";
        try (FileWriter writer = new FileWriter(filename, true)) {
            if (contract instanceof SalesContract){
                SalesContract salesContract =(SalesContract) contract;
                writer.write("Sales Contract\n");
                writer.write("Date: " + salesContract.getDate() + "\n");
                writer.write("Customer Name: " + salesContract.getCustomerName() + "\n");
                writer.write("Customer Email: " + salesContract.getCustomerEmail() + "\n");
                writer.write("Vehicle Sold: " + salesContract.getVehicleSold() + "\n");
                writer.write("Total Price: " + salesContract.getTotalPrice() + "\n");
                writer.write("Monthly Payment: " + salesContract.getMonthlyPayment() + "\n");

                // Additional information for SalesContract can be ADD here
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                writer.write("Lease Contract\n");
                writer.write("Date: " + leaseContract.getDate() + "\n");
                writer.write("Customer Name: " + leaseContract.getCustomerName() + "\n");
                writer.write("Customer Email: " + leaseContract.getCustomerEmail() + "\n");
                writer.write("Vehicle Sold: " + leaseContract.getVehicleSold() + "\n");
                writer.write("Total Price: " + leaseContract.getTotalPrice() + "\n");
                writer.write("Monthly Payment: " + leaseContract.getMonthlyPayment() + "\n");
// Additional information for LeaseContract can be appended here
            } else {
                writer.write("Unknown Contract\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}

