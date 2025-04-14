package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner realtor = new Scanner(System.in);

        //user input
        System.out.println(" Enter the loan principal amount: ");
        double principal = realtor.nextDouble();

        System.out.println(" Enter the annual interest rate ( as a percentage, e.g., 7.625 or 5.125 ");
        double annualRate = realtor.nextDouble()/100; // convert to decimal

        System.out.println(" Enter the loan term (in years): ");
        int years = realtor.nextInt();

        // monthly interes and number of payments
        double monthlyRate = annualRate/12;
        int numPayments = years* 12;

        //calculation
        double monthlyPayment = principal *
                (monthlyRate * Math.pow(1 + monthlyRate, numPayments)) /
                (Math.pow(1 + monthlyRate, numPayments) - 1);

        //total interest
        double totalInterest = (monthlyPayment* numPayments) - principal;
        double totalLoanAmount = monthlyPayment * numPayments;

        // results yayyy!
        System.out.printf(" Your monthly payment is $%.2f%n",monthlyPayment );
        System.out.printf("Total interest paid over the loan term: $%.2f%n",totalInterest );
        System.out.println("Total Loan equals to $" +totalLoanAmount);
        realtor.close();// realtor no longer needed ;))


    }
}
