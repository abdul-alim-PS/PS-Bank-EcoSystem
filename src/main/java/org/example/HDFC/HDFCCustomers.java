package org.example.HDFC;

import org.example.Customer;

import java.io.BufferedReader;

public class HDFCCustomers extends Customer {
    public HDFCCustomers(BufferedReader buff) {
        super(buff,"HDFC");
    }
}
