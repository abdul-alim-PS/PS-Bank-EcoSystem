package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.pow;

public class RBI {
    float amount;
    float ROI;
    int year;
    Customer customer;

    public RBI(BufferedReader buff,int selectedOperation,Customer customer) {
        this.customer = customer;
        switch (selectedOperation){
            case 1:
                System.out.println("Enter the amount to be Added:");
                try {
                    amount = Float.parseFloat(buff.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                depositMoney(amount);
                break;
            case 2:
                System.out.println("Enter the amount to be withdrawn:");
                try {
                    amount = Float.parseFloat(buff.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                withdrawMoney(amount);
                break;
            case 3:
                System.out.println("Enter the amount for which FD will be calculated for 3 years.");
                try {
                    amount = Float.parseFloat(buff.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                ROI = 0.06f;
                year = 3;
                openFD(amount,ROI,year);
                break;
            case 4:
                System.out.println("Enter how much loan you wanna apply");
                try {
                    amount = Float.parseFloat(buff.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                System.out.println("Enter duration you are applying for");
                try {
                    year = Integer.parseInt(buff.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                ROI = 0.06f;
                applyLoan("Simple",amount,ROI,year);
                break;
            default:
                System.out.println("Enter valid operation");
        }

    }

    public void depositMoney(float amount) {
        float balance = customer.getBalance();
        customer.setBalance(balance+amount);
        System.out.println("Amount "+amount+"added to the account, New balance: "+customer.getBalance());
    }
    public void withdrawMoney(float withdraw){
        float balance = customer.getBalance();
        int counter = customer.getCounter();
        if(balance-withdraw<1000){
            System.out.println("Can not withdraw the amount, balance will be less than 1000 ");
        }
        else if(counter<4){
            customer.setBalance(balance-withdraw);
            customer.setCounter(counter+1);
            System.out.println("Amount "+withdraw+" has been withdrawn from account new balance: "+customer.getBalance());
        }
        else if(balance-(withdraw+withdraw * 0.001f)>1000){
            customer.setBalance(balance - (withdraw+withdraw * 0.001f));
            customer.setCounter(counter+1);
            System.out.println("Amount "+withdraw+" has been withdrawn from account new balance: "+customer.getBalance());
        }
        else{
            System.out.println("Amount cannot deducted your with-drawl counter exhausted.");
        }
    }
    public void openFD(float amount, float ROI, int years) {
        System.out.println("FD Evaluation with Amount: "+amount+" ROI: "+ROI*100+" years: "+years);
        float fd = amount*(1+ROI);
        System.out.println("First Year Capitol: "+fd);
        fd *= (1+ROI);
        System.out.println("Second Year Capitol: "+fd);
        fd *= (1+ROI);
        System.out.println("Third Year Capitol: "+fd);
        System.out.println("Total Profit: "+(fd-amount));

    }
    public void applyLoan(String loanType, float amount, float ROI, int years) {
        double totalAmount = amount*pow((1+ROI),years);
        System.out.println("The Amount need to paid by you at the end of "+years+" is: "+totalAmount);
    }
    public void applyCreditCard() {}
    public float getBalance() {
        return 0.0f;
    }
}