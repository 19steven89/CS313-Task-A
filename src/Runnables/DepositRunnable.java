package Runnables;

import model.AccountADT;
import model.Customer;

public class DepositRunnable implements Runnable {

    private static final int DELAY = 2;
    private AccountADT account;
    private double amount;

    public DepositRunnable(AccountADT a,double d){
        account = a;
        amount = d;
    }

    public void run(){
        try {
            account.deposit(amount);
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
