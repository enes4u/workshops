package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {
    private static final String CONTRACT_FILE = "contracts.csv";
    private static final String CONTRACT_WITH_HEADINGS_FILE = "contracts_with_headings.csv";

    public void saveContract(Contract contract) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CONTRACT_FILE, true))) {
            String contractLine;

            if (contract instanceof SalesContract) {
                SalesContract sale = (SalesContract) contract;
                contractLine = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%s|%.2f",
                        sale.getDate(), sale.getCustomerName(), sale.getCustomerEmail(),
                        sale.getVehicle().getVin(), sale.getVehicle().getYear(), sale.getVehicle().getMake(), sale.getVehicle().getModel(),
                        sale.getVehicle().getVehicleType(), sale.getVehicle().getColor(),sale.getVehicle().getOdometer(),sale.getVehicle().getPrice(),
                        sale.getTotalPrice(),
                        sale.isFinanceOption() ? "YES" : "NO",
                        sale.getMonthlyPayment());
            } else if (contract instanceof LeaseContract) {
                LeaseContract lease = (LeaseContract) contract;
                contractLine = String.format("LEASE|%s|%s|%s|%d|%.2f|%.2f",
                        lease.getDate(), lease.getCustomerName(), lease.getCustomerEmail(),
                        lease.getVehicle().getVin(), lease.getTotalPrice(), lease.getMonthlyPayment());
            } else {
                return; // Ignore unknown contract types
            }

            // Save to original contracts file
            writer.println(contractLine);
            writer.flush();

            // Save to contracts_with_headings.csv with specific positioning
            saveToContractsWithHeadings(contractLine, contract instanceof SalesContract);
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }

    private void saveToContractsWithHeadings(String contractLine, boolean isSale) {
        try {
            List<String> lines = new ArrayList<>();
            File file = new File(CONTRACT_WITH_HEADINGS_FILE);

            // Read existing file content
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                }
            } else {
                // Add headers if file doesn't exist
                lines.add("Type|Contract Date|Customer Name|Customer Email|VIN|Total Price|Monthly Payment|Finance Option");
            }

            if (isSale) {
                // Append SALE contract as the second line
                lines.add(1, contractLine);
            } else {
                // Append LEASE contract at the last line
                lines.add(contractLine);
            }

            // Write back to file
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, false))) {
                for (String line : lines) {
                    writer.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating contracts_with_headings.csv: " + e.getMessage());
        }
    }
}
