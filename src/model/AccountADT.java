package model;

public interface AccountADT {
    boolean withdraw(double amount);
    boolean deposit(double amount);
    boolean transfer(AccountADT source, AccountADT target,double amount);
    double getBalance();
}
