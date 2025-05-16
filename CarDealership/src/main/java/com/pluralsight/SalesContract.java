package com.pluralsight;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final int RECORDING_FEE = 100;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption) {
        super(date, customerName, customerEmail, vehicleSold);
        this.financeOption = financeOption;
        this.processingFee = vehicleSold.getPrice() < 10000 ? 295 : 495;
        this.totalPrice = calculateTotalPrice(vehicleSold.getPrice());
        this.monthlyPayment = financeOption ? calculateMonthlyPayment(vehicleSold.getPrice()) : 0;
    }

    private double calculateTotalPrice(double vehiclePrice) {
        return vehiclePrice + (vehiclePrice * SALES_TAX_RATE) + RECORDING_FEE + processingFee;
    }

    private double calculateMonthlyPayment(double vehiclePrice) {
        double rate = vehiclePrice >= 10000 ? 0.0425 : 0.0525;
        int months = vehiclePrice >= 10000 ? 48 : 24;
        return (vehiclePrice * (1 + rate * months / 12)) / months;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    // Additional Getters for fields unique to SalesContract
    public boolean isFinanceOption() { return financeOption; }

}