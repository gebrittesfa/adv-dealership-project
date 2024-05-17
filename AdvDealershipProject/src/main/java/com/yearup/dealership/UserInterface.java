package com.yearup.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class UserInterface {
    Dealership dealership;
    DealerShipFileManager dealerShipFileManager;

    Vehicle vehicle4 = new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Gray", 103221, 6995.00);

    public UserInterface() {
        init();
    }

    // private method to initiallize the dealership
    private void init() {
        //create a new  dealership object
        //dealership = new Dealership();
        //create a new  dealerShipFileManager object
        dealerShipFileManager = new DealerShipFileManager();
        //create a new  dealership object
        dealership = dealerShipFileManager.getDealership();

    }

   /* private Dealership userFace() {
        // Create DealershipFileManager instance to load dealership data from file
        return this.dealership;
        // Load dealership data  // Delimiter for parsing data in the file
       // this.dealership = dealerShipFileManager;
    }*/

    public void display() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        //while (true) {
        // Display menu options
        System.out.println("\nDealership Application Menu:");
        System.out.println("1. Find vehicles within a price range");
        System.out.println("2. Find vehicles by make / model");
        System.out.println("3. Find vehicles by year range");
        System.out.println("4. Find vehicles by color");
        System.out.println("5. Find vehicles by mileage range");
        System.out.println("6. Find vehicles by type");
        System.out.println("7. List all vehicles");
        System.out.println("8. Add a vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("10. Sell Vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("99. Quit");
        System.out.println("Enter your choice: ");


        int option = scanner.nextInt();

        while (option != 99) {

            // Dispatch user's choice to appropriate method
            switch (option) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;

                case 3:
                    processGetByYearRangeRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRangeRequest();
                    break;
                case 6:
                    processGetByTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    sellVehicle();
                    break;
                case 11:
                    leaseVehicle();
                    break;
                case 99:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println("Do you want another choice?");
            option = scanner.nextInt();
        }
    }

    private void leaseVehicle() {
        // Gather input from the user
        System.out.println("Enter VIN of the vehicle to sell: ");
        String vin = scanne.nextLine();
        Vehicle vehicle = inventory.findVehicleByVIN(vin);

        if (vehicle == null){
            System.out.println("Vehicle not found in inventory.");
            return;
        }

    }

    private void sellVehicle() {
        // Gather input from the user
        System.out.println("Enter VIN of the vehicle to sell: ");
        String vin = scanne.nextLine();
        Vehicle vehicle = inventory.findVehicleByVIN(vin);

        if (vehicle == null){
            System.out.println("Vehicle not found in inventory.");
            return;
        }
    }

    List<Vehicle> processGetByPriceRequest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the minimum price of the vehicle: ");
        double minPrice = input.nextDouble();
        System.out.println("Enter the maximum price of the vehicle: ");
        double maxPrice = input.nextDouble();
        return dealership.getVehiclesByPrice(maxPrice, maxPrice);
    }

    List<Vehicle> processGetByMakeModelRequest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Make or Model of the vehicle: ");
        String model = input.nextLine();
        return dealership.getVehiclesByMakeModel(model);
    }

    List<Vehicle> processGetByYearRangeRequest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the minimum year of the vehicle: ");
        int minYear = input.nextInt();
        System.out.println("Enter the maximum year of the vehicle: ");
        int maxYear = input.nextInt();

        return dealership.getVehiclesByYear( minYear, maxYear);
    }
//    List<Vehicle> processGetByYearRangeRequest() {
//        return dealership.getVehiclesByYear( 1995,2012);
//    }

    List<Vehicle>  processGetByColorRequest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the color: ");
        String color = input.nextLine();
        return dealership.getVehiclesByColor(color);
    }

    List<Vehicle> processGetByMileageRangeRequest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the minimum mileage: ");
        int minMile = input.nextInt();
        System.out.println("Enter the maximum mileage: ");
        int maxMile = input.nextInt();
        return dealership.getVehiclesByMileage( minMile, maxMile);
    }
//    List<Vehicle> processGetByMileageRangeRequest() {
//        return dealership.getVehiclesByMileage( 120000,180000);
//    }

    List<Vehicle> processGetByTypeRequest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the vehicle type: ");
        //String byType = input.next();
        String byType = input.nextLine();

        return dealership.getVehiclesByType(byType);
    }

    List<Vehicle> processGetAllVehiclesRequest() {
        return dealership.getAllVehicles();
    }
    //    private void processAddVehicleRequest() {
//        dealership.addVehicle(vehicle4);
//    }
    private void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the vehicle vin: ");
        int vin = scanner.nextInt();
        System.out.println("Enter the year: ");
        int year =scanner.nextInt();
        System.out.println("Enter the make: ");
        String make = scanner.next();
        System.out.println("Enter the model: ");
        String model = scanner.next();
        System.out.print("Enter the type: ");
        String vehicleType = scanner.next();
        System.out.println("Enter the color: ");
        String color = scanner.next();
        System.out.print("Enter the mileage: ");
        int odometer = scanner.nextInt();
        System.out.println("Enter the vehicle price: ");
        double price = scanner.nextDouble();
        Vehicle newVehicle = new Vehicle( vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully!");
        dealership.addVehicle(newVehicle);
    }
    private void processRemoveVehicleRequest() {
        dealership.removeVehicle("car");
    }
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            // Display list of vehicles
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }
    private void processListAllVehiclesRequest() {
        // Retrieve all vehicles from dealership
        ArrayList<Vehicle> allVehicles = (ArrayList<Vehicle>) dealership.getAllVehicles();
        // Display all vehicles
        displayVehicles(allVehicles);
    }


}

