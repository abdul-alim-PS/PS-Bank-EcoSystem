package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class Customer {
    private String customerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone;
    private float balance;
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Customer(BufferedReader buff){
        try {
            System.out.print("Enter name:");
            customerName = buff.readLine();
            System.out.print("Enter email:");
            customerEmail = buff.readLine();
            System.out.print("Enter Gender:");
            customerGender = buff.readLine();
            System.out.print("Enter Phone:");
            customerPhone = buff.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        balance = 1000;
        counter = 0;
    }

    public Customer(String customerName, String customerEmail, String customerAddress, String customerGender, String customerAadhar, String customerPhone, float balance) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerGender = customerGender;
        this.customerAadhar = customerAadhar;
        this.customerPhone = customerPhone;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAadhar() {
        return customerAadhar;
    }

    public void setCustomerAadhar(String customerAadhar) {
        this.customerAadhar = customerAadhar;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}