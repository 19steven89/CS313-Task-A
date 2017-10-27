package model;

public class CurrentAccount implements AccountADT {

    private int accountID;
    private double balance;

    public CurrentAccount(int accountID, double balance){
        setAccountID(accountID);
        setBalance(balance);
    }

    public boolean withdraw(double amount){


        return true;
    }
    public boolean deposit(double amount){
        return true;
    }
    public boolean transfer(AccountADT source, AccountADT target,double amount){
        return true;
    }


    public void setAccountID(int accountID){
        this.accountID = accountID;
    }

    public int getAccountID(){
        return accountID;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }
}
