package model;

public interface AccountADT {
    boolean withdraw(double amount);
    boolean deposit(double amount);
    double getBalance();
    boolean transState(double amount);
    void setAccountId(int accountID);
    int getAccountId();


}
