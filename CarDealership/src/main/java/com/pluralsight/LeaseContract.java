package com.pluralsight;

public class LeaseContract extends Contract {
    private static final double LEASE_FEE_RATE = 0.07;
    private static final double LEASE_INTEREST_RATE = 4.0 / 1200;
    private static final int LEASE_TERM = 36;
    private double expectedEndingValue;
    private double leaseFee;

    // Constructor
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.5;
        this.leaseFee = vehicleSold.getPrice() * LEASE_FEE_RATE;
    }    @Override
    public double getTotalPrice() {
        double totalPrice = (getVehicle().getPrice() - expectedEndingValue) + leaseFee;
        System.out.println("Calculating total price for lease contract: " + totalPrice);
        return totalPrice;    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }
    // Additional Getters for fields unique to LeaseContract
    public double getExpectedEndingValue() { return expectedEndingValue; }
    public double getLeaseFee() { return leaseFee; }
}