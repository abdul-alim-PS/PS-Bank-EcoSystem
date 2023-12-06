package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bank {

    public Bank(BufferedReader buff,Customer customer,int selectedBank,int selectedOperation) {
        switch (selectedBank){
            case 1: RBI rbi = new RBI(buff,selectedOperation,customer);
            break;
            default: System.out.println("Enter valid bank number");
        }
    }
}
