package org.example.SBI;

import org.example.Customer;

import java.io.BufferedReader;

public class SBICustomers extends Customer {
    public SBICustomers(BufferedReader buff) {
        super(buff,"SBI");
    }
}
