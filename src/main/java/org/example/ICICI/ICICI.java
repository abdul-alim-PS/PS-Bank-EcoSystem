package org.example.ICICI;

import org.example.Customer;
import org.example.CustomerListStorage;
import org.example.ICICI.enums.Constants;
import org.example.ICICI.enums.TypesOfLoan;
import org.example.RBI;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;

import static java.lang.Math.pow;
import static org.example.Main.LOGGER;

public class ICICI implements RBI {
    float amount;
    int typeOfLoan;
    float ROI;
    int fdYear;
    int loanYear;
    Customer customer;
    float minimum_balance;

    public ICICI(BufferedReader buff,CustomerListStorage customerList) {
        LOGGER.log(Level.INFO,"Enter Customer Details: ");
        this.customer = new ICICICustomers(buff);
        this.minimum_balance = Constants.MINIMUM_BALANCE.getValue();
        String answer = null;
        boolean choice_flag = true;
        int selectedOperation=0;
        while (choice_flag) {
            LOGGER.log(Level.INFO,"Welcome to ICICI Select your choice\n1. Deposit\n2. Withdraw\n3. OpenFD\n4. Apply Loan\n5. Apply cc\n6. Get Balance");
            try {
                selectedOperation = Integer.parseInt(buff.readLine());
            } catch (IOException e) {
                LOGGER.log(Level.INFO,e.getMessage());
            }
            LOGGER.log(Level.INFO,"Customer Selected Operation " + selectedOperation);
            callingOperations(buff,selectedOperation);
            LOGGER.log(Level.INFO,"Would you like to exit From Bank (yes/no): ");
            try {
                answer = buff.readLine();
            } catch (IOException e) {
                LOGGER.log(Level.INFO,e.getMessage());
            }
            if (answer != null && answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                choice_flag = false;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                choice_flag = true;
            }
        }
        customerList.addCustomer(customer);
    }
    private void callingOperations(BufferedReader buff,int selectedOperation){
        switch (selectedOperation){
            case 1:
                LOGGER.log(Level.INFO,"Enter the amount to be Added:");
                try {
                    amount = Float.parseFloat(buff.readLine());
                }
                catch(IOException e){
                    LOGGER.log(Level.INFO,e.getMessage());
                }
                depositMoney(amount);
                break;
            case 2:
                LOGGER.log(Level.INFO,"Enter the amount to be withdrawn:");
                try {
                    amount = Float.parseFloat(buff.readLine());
                }
                catch(IOException e){
                    LOGGER.log(Level.INFO,e.getMessage());
                }
                withdrawMoney(amount);
                break;
            case 3:
                LOGGER.log(Level.INFO,"Enter the amount for which FD will be calculated for 3 years.");
                try {
                    amount = Float.parseFloat(buff.readLine());
                }
                catch(IOException e){
                    LOGGER.log(Level.INFO,e.getMessage());
                }
                ROI = Constants.FD_ROI.getValue();
                fdYear = (int)Constants.FD_YEAR.getValue();
                openFD(amount,ROI,fdYear);
                break;
            case 4:
                LOGGER.log(Level.INFO,"Enter the type of loan\n1. Home\n2. Education\n3. Personal\n4. Car");
                try {
                    typeOfLoan = Integer.parseInt(buff.readLine());
                }
                catch(IOException e){
                    LOGGER.log(Level.INFO,e.getMessage());
                }
                LOGGER.log(Level.INFO,"Enter how much loan you wanna apply");
                try {
                    amount = Float.parseFloat(buff.readLine());
                }
                catch(IOException e){
                    LOGGER.log(Level.INFO,e.getMessage());
                }
                LOGGER.log(Level.INFO,"Enter duration you are applying for");
                try {
                    loanYear = Integer.parseInt(buff.readLine());
                }
                catch(IOException e){
                    LOGGER.log(Level.INFO,e.getMessage());
                }
                applyLoan(TypesOfLoan.getByOrder(typeOfLoan).getName(),amount,TypesOfLoan.getByOrder(typeOfLoan).getROI(),loanYear);
                break;
            case 5:
                applyCreditCard();
                break;
            case 6:
                getBalance();
            default:
                LOGGER.log(Level.INFO,"Enter valid operation");
        }
    }
    @Override
    public void depositMoney(float amount) {
        float balance = customer.getBalance();
        customer.setBalance(balance+amount);
        LOGGER.log(Level.INFO,"Amount "+amount+"added to the account, New balance: "+customer.getBalance());
    }

    @Override
    public void withdrawMoney(float withdraw) {
        float balance = customer.getBalance();
        int counter = customer.getCounter();
        if(balance-withdraw<minimum_balance){
            LOGGER.log(Level.INFO,"Can not withdraw the amount, balance will be less than 1000 ");
        }
        else if(counter<3){
            customer.setBalance(balance-withdraw);
            customer.setCounter(counter+1);
            LOGGER.log(Level.INFO,"Amount "+withdraw+" has been withdrawn from account new balance: "+customer.getBalance());
        }
        else if(balance-(withdraw+withdraw * 0.001f)>minimum_balance){
            customer.setBalance(balance - (withdraw+withdraw * 0.001f));
            customer.setCounter(counter+1);
            LOGGER.log(Level.INFO,"Amount "+withdraw+" has been withdrawn from account new balance: "+customer.getBalance());
        }
        else{
            LOGGER.log(Level.INFO,"Amount cannot deducted your with-drawl counter exhausted.");
        }
    }

    @Override
    public void openFD(float amount, float ROI, int years) {
        LOGGER.log(Level.INFO,"FD Evaluation with Amount: "+amount+" ROI: "+ROI*100+" years: "+years);
        float fd = amount*(1+ROI);
        LOGGER.log(Level.INFO,"First Year Capitol: "+fd);
        fd *= (1+ROI);
        LOGGER.log(Level.INFO,"Second Year Capitol: "+fd);
        fd *= (1+ROI);
        LOGGER.log(Level.INFO,"Third Year Capitol: "+fd);
        LOGGER.log(Level.INFO,"Total Profit: "+(fd-amount));
    }

    @Override
    public void applyLoan(String loanType, float amount, float ROI, int years) {
        float balance = customer.getBalance();
        if(balance>(minimum_balance*2)) {
            double totalAmount = amount * pow((1 + ROI), years);
            LOGGER.log(Level.INFO,"For loan type " + loanType + "The Amount need to paid by you at the end of " + years + " is: " + totalAmount);
        }
        else{
            LOGGER.log(Level.INFO,"You are not eligible for loan");
        }
    }

    @Override
    public void applyCreditCard() {
        float balance = customer.getBalance();
        if(balance>(minimum_balance*2)) {
            LOGGER.log(Level.INFO,"You are eligible for credit card. With credit ROI: "+(Constants.CREDIT_ROI.getValue()*100));
        }
        else{
            LOGGER.log(Level.INFO,"You are not eligible for credit card");
        }
    }

    @Override
    public void getBalance() {
        LOGGER.log(Level.INFO,"Your Balance is: "+customer.getBalance());
    }
}
