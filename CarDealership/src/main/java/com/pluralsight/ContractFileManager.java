package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {
    private static final String CONTRACT_FILE = "contracts.csv";

    public void saveContract(Contract contract) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("contracts.csv", true))) {
            if (contract instanceof SalesContract) {
                SalesContract sale = (SalesContract) contract;
                writer.printf("SALE|%s|%s|%s|%d|%.2f|%.2f|%s%n",
                        sale.getDate(), sale.getCustomerName(), sale.getCustomerEmail(),
                        sale.getVehicle().getVin(), sale.getTotalPrice(), sale.getMonthlyPayment(),
                        sale.isFinanceOption() ? "YES" : "NO");
            } else if (contract instanceof LeaseContract) {
                LeaseContract lease = (LeaseContract) contract;
                writer.printf("LEASE|%s|%s|%s|%d|%.2f|%.2f%n",
                        lease.getDate(), lease.getCustomerName(), lease.getCustomerEmail(),
                        lease.getVehicle().getVin(), lease.getTotalPrice(), lease.getMonthlyPayment());
            }
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }


    public List<Contract> loadContracts() {
        List<Contract> contracts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTRACT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                Contract contract;
                if (parts[0].equals("SALE")) {
                    contract = new SalesContract(parts[1], parts[2], parts[3],
                            new Vehicle(Integer.parseInt(parts[4]), 0, "", "", "", "", 0, 0.0), parts[7].equals("YES"));
                } else {
                    contract = new LeaseContract(parts[1], parts[2], parts[3],
                            new Vehicle(Integer.parseInt(parts[4]), 0, "", "", "", "", 0, 0.0));
                }
                contracts.add(contract);
            }
        } catch (IOException e) {
            System.out.println("Error loading contracts: " + e.getMessage());
        }
        return contracts;
    }
}