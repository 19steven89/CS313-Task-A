package Runnables;

import model.AccountADT;
import model.Customer;

public class BalanceRunnable implements Runnable {

    private static final int DELAY = 1;
    private AccountADT account;
    private Customer customer;

    public BalanceRunnable(Customer c,AccountADT a){
        account = a;
        customer = c;
    }

    public void run(){
        try {
            customer.viewBalance(account);
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
