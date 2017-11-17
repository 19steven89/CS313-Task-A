package model;

public class CurrentAccount implements AccountADT {

    private int accountID;
    private double balance;

    public CurrentAccount(int accountID, double balance){
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

    public boolean transState(double amount){
        if((getBalance() + 500.0) < amount){
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
