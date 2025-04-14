package com.pluralsight;

import java.util.Scanner;

public class FutureValueCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter the initial deposit amount: ");
        double deposit = scanner.nextDouble();

        System.out.println(" Enter annual interest rate ( as a percentage, e.g. 1.75 or 2.54: ");
        double annualRate = scanner.nextDouble()/100; //decimall

        System.out.println(" ENter the number of years:  ");
        int years = scanner.nextInt();

        //days per year
        int daysPerYear =365;
        // Calculate future value using the formula FV = P * (1 + (r / 365))^(365 * t)
        double futureValue = deposit *
                Math.pow(1 + (annualRate / daysPerYear), daysPerYear * years);

        double totalInterest = futureValue - deposit;

        // results

        System.out.printf("The future value of the deposit is: $%.2f%n", futureValue);
        System.out.printf("The total interest earned is: $%.2f%n", totalInterest);

        scanner.close();









    }
}
