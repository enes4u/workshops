package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    private DealershipFileManager fileManager;

    public UserInterface() {
        fileManager = new DealershipFileManager();  // Initializes fileManager
        init();
    }
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    // Main display method with menu and choice handling
    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": processGetAllVehiclesRequest(); break;
                case "2": processGetByPriceRequest(); break;
                case "3": processGetByMakeModelRequest(); break;
                case "4": processGetByYearRequest(); break;
                case "5": processGetByColorRequest(); break;
                case "6": processGetByMileageRequest(); break;
                case "7": processGetByVehicleTypeRequest(); break;
                case "8": processAddVehicleRequest(); break;
                case "9": processRemoveVehicleRequest(); break;
                case "10": running = false; break;
                default: System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    // Displays the main menu
    private void displayMenu() {
        System.out.println("\nCar Dealership Application");
        System.out.println("1. List all vehicles");
        System.out.println("2. Find vehicles by price range");
        System.out.println("3. Find vehicles by make and model");
        System.out.println("4. Find vehicles by year range");
        System.out.println("5. Find vehicles by color");
        System.out.println("6. Find vehicles by mileage range");
        System.out.println("7. Find vehicles by type");
        System.out.println("8. Add a vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("10. Quit");
        System.out.print("Enter your choice: ");
    }

    // Displays all vehicles in the dealership
    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
    // Finds vehicles by price range
    private void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }
    // Finds vehicles by make and model
    private void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    // Finds vehicles by year range
    private void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    // Finds vehicles by color
    private void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    // Finds vehicles by mileage range
    private void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    // Finds vehicles by type
    private void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle type (e.g., sedan, truck, SUV): ");
        String type = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    // Adds a new vehicle to the dealership
    private void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter odometer reading: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        fileManager.saveDealership(dealership);
        System.out.println("Vehicle added successfully.");
    }

    // Removes a vehicle from the dealership
    private void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vin = scanner.nextInt();

        Vehicle toRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                toRemove = vehicle;
                break;
            }
        }

        if (toRemove != null) {
            dealership.removeVehicle(toRemove);
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    // Helper method to display a list of vehicles
    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.printf("VIN: %d, Year: %d, Make: %s, Model: %s, Type: %s, Color: %s, Odometer: %d, Price: $%.2f%n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }

}