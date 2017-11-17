package Runnables;

import model.AccountADT;
import model.Customer;

public class DepositRunnable implements Runnable {

    private static final int DELAY = 2;
    private AccountADT account;
    private Customer customer;
    private double amount;

    public DepositRunnable(Customer c,AccountADT a,double d){
        account = a;
        amount = d;
        customer = c;
    }

    public void run(){
        try {
            customer.deposit(account,amount);
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
