package org.example.IDFC;

import org.example.Customer;

import java.io.BufferedReader;

public class IDFCCustomers extends Customer {
    public IDFCCustomers(BufferedReader buff) {
        super(buff,"IDFC");
    }
}
