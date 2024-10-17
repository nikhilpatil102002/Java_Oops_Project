package com.bank.account;

import com.bank.customer.Customer;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, Customer customer, double interestRate) {
        super(accountNumber, customer);
        this.interestRate = interestRate;
    }
    
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
    
    public void applyInterest() {
        balance += (balance * interestRate);
        System.out.println("Interest applied: " + interestRate * 100 + "%");
    }
}
