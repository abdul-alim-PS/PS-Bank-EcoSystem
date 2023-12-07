package org.example;

public interface RBI {
    public void depositMoney(float amount);
    public void withdrawMoney(float withdraw);
    public void openFD(float amount, float ROI, int years);
    public void applyLoan(String loanType, float amount, float ROI, int years);
    public void applyCreditCard();
    public void getBalance();
}
