package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>(); // Initialize inventory
    }

    // Getter methods for dealership details
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // Add a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Return all vehicles
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }




    // Search stubs
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                results.add(vehicle);
            }
        }
        return results;
    }
    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle vehicle : inventory) { // Assuming 'inventory' is the list of vehicles.
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }


    // Stub for removeVehicle method
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}