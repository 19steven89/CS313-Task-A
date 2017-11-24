package model;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicAccount implements AccountADT{

    private String customerID;
    private int accountID;
    private double balance;
    private int type;
    private Lock accountLock;
    private Condition enoughFundsCondition;

    public BasicAccount(String customerID, int accountID, double balance){
        accountLock = new ReentrantLock();
        enoughFundsCondition = accountLock.newCondition();
        setCustomerID(customerID);
        setAccountID(accountID);
        setBalance(balance);
        setType(1);
    }

    public boolean withdraw(double amount){
        boolean stillWaiting = true;
        accountLock.lock();
        try {
            System.out.println("Withdraw Thread : Balance is " + getBalance() + " at the start of the thread");
            System.out.println("Withdraw Thread : Attempting to withdraw "+ amount);
            while(!transState(amount)){
                if(!stillWaiting){
                    Thread.currentThread().interrupt();
                }
                stillWaiting = enoughFundsCondition.await(1, TimeUnit.SECONDS);
            }
            setBalance(getBalance()-amount);
            System.out.println("Withdraw Thread : Balance is " + getBalance() + " at the end of the thread");
        }catch(InterruptedException e){
            System.out.println("Can't Wait Any Longer!");
            return false;
        }finally{
            enoughFundsCondition.signalAll();
            accountLock.unlock();
        }
        return true;
    }

    public boolean deposit(double amount){
        accountLock.lock();
        try {
            System.out.println("Deposit Thread : Balance at start: "+ getBalance());
            setBalance(getBalance()+amount);
            System.out.println("Deposit Thread : Amount deposited: "+amount);
            System.out.println("Deposit Thread : Balance at end: "+ getBalance());
        } finally{
            enoughFundsCondition.signalAll();
            accountLock.unlock();
        }

        return true;
    }

    @Override
    public boolean transfer(AccountADT target, double amount) {
        accountLock.lock();
        try {
            if(!withdraw(amount)){
                System.out.println("Insufficient funds! ");
                return false;
            }
            target.deposit(amount);
        }finally{
            enoughFundsCondition.signalAll();
            accountLock.unlock();
        }
        return true;
    }

    public boolean transState(double amount){
        if((getBalance() - amount) < 0){
            return false;
        }
        return true;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        accountLock.lock();
        try{
            return balance;
        }finally {
            enoughFundsCondition.signalAll();
            accountLock.unlock();
        }
    }

    public void setAccountID(int accountID){
        this.accountID = accountID;
    }

    public int getAccountID(){
        return accountID;
    }

    public int getType() {
        return type;
    }

    private void setType(int type) {
        this.type = type;
    }
}