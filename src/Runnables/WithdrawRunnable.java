package Runnables;

import model.AccountADT;
import model.Customer;

public class WithdrawRunnable implements Runnable {

    private static final int DELAY = 1;
    private AccountADT account;
    private Customer customer;
    private double amount;

    public WithdrawRunnable(Customer c,AccountADT a,double d){
        customer = c;
        account = a;
        amount = d;
    }

    public void run(){
        try {
            customer.withdraw(account,amount);
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
