package com.bank.customer;

public class Customer {
    private String name;
    private String contactNumber;
    private String address;
    
    public Customer(String name, String contactNumber, String address) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
    }
    
    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "Customer [Name=" + name + ", Contact=" + contactNumber + ", Address=" + address + "]";
    }
}

