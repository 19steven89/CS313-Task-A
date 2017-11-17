package model;

public class BasicAccount implements AccountADT{

    private int accountID;
    private double balance;

    public BasicAccount(int accountID, double balance){
        setAccountID(accountID);
        setBalance(balance);
    }

    public boolean withdraw(double amount){
        if(getBalance()<amount){
            return false;
        } else {
            setBalance(getBalance()-amount);
        }
        return true;
    }

    public boolean deposit(double amount){
        setBalance(getBalance()+amount);
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

    public int getID(){
        return accountID;
    }

    public boolean transState(double amount){
        if(getBalance() < amount){
            return false;
        }
        return true;
    }

    public void setAccountId(int accountID){
        this.accountID = accountID;
    }
    public int getAccountId(){
        return accountID;
    }

}