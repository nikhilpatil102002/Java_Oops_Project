package com.bank.account;

import com.bank.customer.Customer;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected Customer customer;
    
    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
    }
    
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Customer getCustomer() { return customer; }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    public abstract void withdraw(double amount);
    
    @Override
    public String toString() {
        return "Account [Account Number=" + accountNumber + ", Balance=" + balance + ", Customer=" + customer + "]";
    }
}