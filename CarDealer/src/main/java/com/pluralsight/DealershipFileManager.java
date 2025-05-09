package com.pluralsight;

import java.io.*;
import java.util.ArrayList;


public class DealershipFileManager {

    // Reads the dealership information from the file and returns a Dealership object
    public Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"))) {
            // Read Dealership info from the first line
            String[] dealershipInfo = reader.readLine().split("\\|");
            dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);

            // Read each vehicle line and add it to the dealership inventory
            String line;
            while ((line = reader.readLine()) != null) {
                String[] vehicleData = line.split("\\|");
                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(vehicleData[0]),  // vin
                        Integer.parseInt(vehicleData[1]),  // year
                        vehicleData[2],                   // make
                        vehicleData[3],                   // model
                        vehicleData[4],                   // vehicleType
                        vehicleData[5],                   // color
                        Integer.parseInt(vehicleData[6]),  // odometer
                        Double.parseDouble(vehicleData[7]) // price
                );
                dealership.addVehicle(vehicle);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return dealership;
    }

    // Writes dealership and inventory data to the file
    public void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("inventory.csv"))) {
            // Write Dealership details (first line)
            writer.printf("%s|%s|%s%n", dealership.getName(), dealership.getAddress(), dealership.getPhone());

            // Write each vehicle in the inventory
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}