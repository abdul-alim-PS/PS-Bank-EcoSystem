package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;

import static org.example.Main.LOGGER;

public class CustomerListStorage {
    public List<Customer> customerList;
    private Set<String> uniqueCustomer;

    public CustomerListStorage() {
        this.uniqueCustomer = new HashSet<>();
        this.customerList = new ArrayList<>();
    }
    public void addCustomer(Customer customer){
        String uniqueCustomerId = customer.getCustomerAadhar()+customer.getBankName();
        if(!uniqueCustomer.contains(uniqueCustomerId)) {
            customerList.add(customer);
            uniqueCustomer.add(customer.getCustomerAadhar() + customer.getBankName());
        }
    }
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    public void countCustomers(){
        if(customerList.isEmpty()){
            LOGGER.log(Level.INFO,"No customers been added. Please add customer");
            return;
        }
        HashMap<String,Integer> counter = new HashMap<>();
        String bank;
        Integer count;
        for (Customer customer : customerList) {
            bank = customer.getBankName();
            if(counter.get(bank)==null){
                counter.put(bank, 1);
            }
            else {
                count = counter.get(bank);
                counter.put(bank,count+1);
            }
        }
        LOGGER.log(Level.INFO,"Below is the count of customers for each bank");
        counter.forEach((key,value)->LOGGER.log(Level.INFO,"Bank: "+key+" Count of Customers: "+value));
    }
    public void topKOfBankB(BufferedReader buff){
        int k=5,selectBank=0;
        String bank;
        LOGGER.log(Level.INFO,"Select the bank:\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
        try {
            selectBank = Integer.parseInt(buff.readLine());
        } catch (IOException e) {
            LOGGER.log(Level.INFO,e.getMessage());
        }
        switch (selectBank){
            case 1:
                bank = "ICICI";
                break;
            case 2:
                bank = "HDFC";
                break;
            case 3:
                bank = "SBI";
                break;
            case 4:
                bank = "Axis";
                break;
            case 5:
                bank = "IDFC";
                break;
            default:
                return;
        }
        LOGGER.log(Level.INFO,"How many would you like to see");
        try {
            k = Integer.parseInt(buff.readLine());
        } catch (IOException e) {
            LOGGER.log(Level.INFO,e.getMessage());
        }
        if(customerList.isEmpty()){
            LOGGER.log(Level.INFO,"No customers been added. Please add customer");
            return;
        }
        HashMap<String,Float> customerMap = new HashMap<>();
        for(Customer customer:customerList){
            if(customer.getBankName().equalsIgnoreCase(bank)){
                customerMap.put(customer.getCustomerName(),customer.getBalance());
            }
        }
        List<Map.Entry<String, Float>> entryList = new ArrayList<>(customerMap.entrySet());
        Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
        LOGGER.log(Level.INFO,"The top "+k+" balance holder of the bank "+bank+" are given below");
        for(int i=0;i<entryList.size()&&i<k;i++){
            LOGGER.log(Level.INFO,entryList.get(i).getKey()+" : "+entryList.get(i).getValue());
        }
    }
}
