package org.example;

import org.example.AXIS.AXIS;
import org.example.HDFC.HDFC;
import org.example.ICICI.ICICI;
import org.example.IDFC.IDFC;
import org.example.SBI.SBI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main extends Thread{
    int selectedBank;
    boolean bank_flag;
    BufferedReader buff;
    InputStreamReader isr;
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
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
        obj.run();
    }
    @Override
    public void run(){
        CustomerListStorage customerList = new CustomerListStorage();
        while (bank_flag) {
            LOGGER.log(Level.INFO,"Welcome to IBS\nPlease select your bank or other operations\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC\n6. Count Bank Customers\n7. Top Bank Customers\n8. Exit ");
            try {
                selectedBank = Integer.parseInt(buff.readLine());
            } catch (IOException e) {
                LOGGER.log(Level.INFO,e.getMessage());
            }
            LOGGER.log(Level.INFO,"Customer Selected " + selectedBank);
            switch(selectedBank){
                case 1:
                    RBI icici = new ICICI(buff,customerList);
                    break;
                case 2:
                    RBI hdfc = new HDFC(buff,customerList);
                    break;
                case 3:
                    RBI sbi = new SBI(buff,customerList);
                    break;
                case 4:
                    RBI axis = new AXIS(buff,customerList);
                    break;
                case 5:
                    RBI idfc = new IDFC(buff,customerList);
                    break;
                case 6:
                    customerList.countCustomers();
                    break;
                case 7:
                    customerList.topKOfBankB(buff);
                    break;
                case 8:
                    bank_flag = false;
                    break;
                default:
                    LOGGER.log(Level.INFO,"Invalid Input");
            }
        }
    }
}