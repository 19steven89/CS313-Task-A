package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Customer{

    private String name;
    private Lock accountLock;
    private Condition enoughFundsCondition;
    private List<AccountADT> myAccounts;

    public Customer(String name){
        setName(name);
        accountLock = new ReentrantLock();
        enoughFundsCondition = accountLock.newCondition();
        myAccounts = new ArrayList<>(3);
    }

    public AccountADT withdraw(AccountADT account, double amount){

        boolean stillWaiting = true;
        accountLock.lock();
        try {
            while(account.getBalance() < amount){
                if(!stillWaiting){
                    Thread.currentThread().interrupt();
                }
                stillWaiting = enoughFundsCondition.await(1, TimeUnit.SECONDS);
            }
            account.withdraw(amount);
        }catch(InterruptedException e){
            System.out.println("Can't Wait Any Longer!");
            System.exit(1);
        }finally{
            accountLock.unlock();
        }
        return account;
    }

    public AccountADT deposit(AccountADT account, double amount)throws InterruptedException{
        accountLock.lock();
        try {
            account.deposit(amount);
        }finally{
            accountLock.unlock();
        }
        return account;
    }

    public AccountADT transfer(AccountADT source, AccountADT target, double amount){
        return null;
    }

    public void openAccount(AccountADT account){
        myAccounts.add(account);
    }

    public AccountADT getAccount(int accountID) {
        AccountADT account = null;

        return account;
    }

    public double viewBalance(AccountADT account){
        return account.getBalance();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
