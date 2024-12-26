package com.project.atm.model;

public class Account {
    private double balance;
    private final int accountNumber;

    public Account(int accountNumber, double initialBalance){
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
    }

    public String deposit (double amount) {
        if (amount > 0) {
            balance += amount;
            return ("Deposit successful. Balance now: " + balance);
        }
        else
            return ("Deposit amount needs to be a positive number");
    }

    public String withdraw (double amount){
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
            return ("Withdraw successful. Balance now: " + balance);
        }
        else if (amount <= 0)
            return ("Amount withdrawn needs to be a positive number");
        else
            return ("Insufficient funds lol get your money up");
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        if (balance < 0)
            System.out.println("balance cannot be a negative number.");
        else
            this.balance = balance;
    }
}
