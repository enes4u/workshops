package com.pluralsight;

import java.util.Scanner;

public class PresentValueCalculator {
    public static void main(String[] args) {
        Scanner broker = new Scanner(System.in);

        // Gather user input
        System.out.print("Enter the monthly payout amount: ");
        double monthlyPayout = broker.nextDouble();

        System.out.print("Enter the annual interest rate (as a percentage, e.g., 2.5): ");
        double annualRate = broker.nextDouble() / 100; // Convert to decimal

        System.out.print("Enter the number of years to pay out: ");
        int years = broker.nextInt();

        // Calculate monthly interest rate and total number of payments
        double monthlyRate = annualRate / 12;
        int totalPayments = years * 12;

        // Calculate present value using the formula
        double presentValue = monthlyPayout *
                (1 - Math.pow(1 + monthlyRate, -totalPayments)) / monthlyRate;

        // Display results
        System.out.printf("The present value of the annuity is: $%.2f%n", presentValue);

        broker.close();

    }
}
