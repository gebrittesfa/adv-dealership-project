package com.yearup.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**/
public class DealerShipFileManager {
    public Dealership getDealership() {
        Dealership dealership = null;
        String fileName = "inventory.csv";

        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line;
            String[] data1 = bufferedReader.readLine().split("\\|");
            dealership = new Dealership(data1[0], data1[1], data1[2]);
            System.out.println(dealership);
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2],
                        data[3], data[4], data[5], Integer.parseInt(data[6]), Double.parseDouble(data[7]));
                dealership.addVehicle(vehicle);
                System.out.println(vehicle);

            }
        } catch (IOException e) {
            System.out.println("Error found " + e.getMessage());
            e.printStackTrace();
        }
        return dealership;
    }

    //Method to save dealership information to file
    public void saveDealership(Dealership dealership) {

        // assuming to save it to csv file // Save deposit information to CSV file
        String fileName = "inventory.csv";
//        System.out.print("The Vin Number: ");
//        //Prompt the user for the deposit information and save it to the CSV file
//        int vin = input.nextInt();
//        System.out.println("Enter the year:");
//        int year = input.nextInt();
//        System.out.println("Make/Model: ");
//        String make = input.nextLine();
//        System.out.println("Enter the vehicle type: ");
//        String vehicleType = input.nextLine();
//        System.out.println("Color of vehicle: ");
//        String color = input.nextLine();
//        System.out.println("What is the odometer");
//        int odometer = input.nextInt();
//        System.out.println("price: ");
//        double price = input.nextDouble();
//        input.nextLine(); // consume newline
        try {
            FileWriter writer = new FileWriter("inventory.csv", true);
            writer.write("Name: " + getDealership() + "\n");
            //writer.write(vin + "|" + year + "|" + make + "|" + SUV + "|" +"|" + color + "|"+"|" + odometer + "|"+ price + "\n");
            writer.write("Name: " + fileName + "\n");
            //write other properties if needed
            writer.close();
            System.out.println("Dealership information saved successfully");

        } catch (IOException e) {
            System.out.println("An error occurred while save dealership information.");
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
        saveDealership(dealership);
    }
    }

