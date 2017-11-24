package Runnables;

import model.AccountADT;
import model.Customer;

public class TransferRunnable implements Runnable {

    private static final int DELAY = 1;
    private AccountADT accountA;
    private AccountADT accountB;
    private double amount;

    public TransferRunnable(AccountADT a, AccountADT b, double d){
        accountA = a;
        accountB = b;
        amount = d;
    }

    public void run(){
        try {
            accountA.transfer(accountB,amount);
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}


