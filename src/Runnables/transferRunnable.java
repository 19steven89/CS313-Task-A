package Runnables;

import model.AccountADT;
import model.Customer;

public class TransferRunnable implements Runnable {

    private static final int DELAY = 1;
    private AccountADT accountA;
    private AccountADT accountB;
    private Customer customer1;
    private double amount;

    public TransferRunnable(Customer c1, AccountADT a, AccountADT b, double d){
        accountA = a;
        accountB = b;
        amount = d;
        customer1 = c1;
    }

    public void run(){
        try {
            customer1.transfer(accountA,accountB,amount);
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}


