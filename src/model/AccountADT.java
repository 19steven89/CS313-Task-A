package model;

public interface AccountADT {
    boolean withdraw(double amount);
    boolean deposit(double amount);
    boolean transfer(AccountADT target,double amount);
    boolean transState(double amount);
    void setCustomerID(String customerID);
    String getCustomerID();
    void setBalance(double balance);
    double getBalance();
    void setAccountID(int accountID);
    int getAccountID();
    int getType();

}
