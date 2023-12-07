package org.example;

import org.example.AXIS.AXIS;
import org.example.HDFC.HDFC;
import org.example.ICICI.ICICI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int selectedBank,selectedOperation;
    boolean bank_flag;
    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        bank_flag = true;
        if(isr == null) {
            isr = new InputStreamReader(System.in);
        }
        if(buff == null) {
            buff = new BufferedReader(isr);
        }
    }


    public static void main(String[] args) {
        Main obj = new Main();
        while (obj.bank_flag) {
            System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
            try {
                obj.selectedBank = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Customer Selected " + obj.selectedBank);
            switch(obj.selectedBank){
                case 1:
                    ICICI icici = new ICICI(obj.buff);
                    break;
                case 2:
                    HDFC hdfc = new HDFC(obj.buff);
                    break;
                case 4:
                    AXIS axis = new AXIS(obj.buff);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            String answer = null;
            System.out.println("Would you like to exit From IBS (yes/no): ");
            try {
                answer = obj.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (answer != null && answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                obj.bank_flag = false;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                obj.bank_flag = true;
            }
        }
    }
}