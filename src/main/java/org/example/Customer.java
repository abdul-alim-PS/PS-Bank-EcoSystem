package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;

import static org.example.Main.LOGGER;

public class Customer {
    private String bankName,customerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone;
    private float balance;
    private int counter;
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Customer(BufferedReader buff,String bank){
        try {
            LOGGER.log(Level.INFO,"Enter name:");
            customerName = buff.readLine();
            LOGGER.log(Level.INFO,"Enter email:");
            customerEmail = buff.readLine();
            LOGGER.log(Level.INFO,"Enter Gender:");
            customerGender = buff.readLine();
            LOGGER.log(Level.INFO,"Enter Phone:");
            customerPhone = buff.readLine();
            LOGGER.log(Level.INFO,"Adhaar Card No:");
            customerAadhar = buff.readLine();
        }
        catch(IOException e){
            LOGGER.log(Level.INFO,e.getMessage());
        }
        bankName = bank;
        balance = 1000;
        counter = 0;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}