package Runnables;

import model.AccountADT;
import model.Customer;

public class WithdrawRunnable implements Runnable {

    private static final int DELAY = 1;
    private AccountADT account;
    private double amount;

    public WithdrawRunnable(AccountADT a,double d){
        account = a;
        amount = d;
    }

    public void run(){
        try {
            account.withdraw(amount);
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
