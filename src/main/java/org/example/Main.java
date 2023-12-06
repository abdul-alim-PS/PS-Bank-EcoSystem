package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int selectedBank,selectedOperation;
    boolean flag;
    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        flag = true;
        if(isr == null) {
            isr = new InputStreamReader(System.in);
        }
        if(buff == null) {
            buff = new BufferedReader(isr);
        }
    }


    public static void main(String[] args){
        Main obj = new Main();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank);
        System.out.println("Enter Customer Details: ");
        Customer customer = new Customer(obj.buff);
        String answer=null;
        while(obj.flag) {
            System.out.println("Select your choice\n1. Deposit\n2. Withdraw\n3. OpenFD\n4. Apply Loan\n5. Apply cc");
            try {
                obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Customer Selected Operation " + obj.selectedOperation);
            Bank bank = new Bank(obj.buff, customer, obj.selectedBank, obj.selectedOperation);
            System.out.println("Would you like to exit (yes/no): ");
            try {
                answer = obj.buff.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            if(answer!=null && answer.equalsIgnoreCase("yes")||answer.equalsIgnoreCase("y")){
                obj.flag = false;
            }
            else if(answer.equalsIgnoreCase("no")||answer.equalsIgnoreCase("n")){
                obj.flag = true;
            }
        }
    }
}