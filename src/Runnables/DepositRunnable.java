package Runnables;

import model.AccountADT;
import model.Customer;

public class DepositRunnable implements Runnable {

    private static final int DELAY = 1;
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
            System.out.println("Deposit Thread: Balance at start: "+ account.getBalance());
            customer.deposit(account,amount);
            System.out.println("Deposit Thread: Amount deposited: "+amount);
            System.out.println("Deposit Thread: Balance at end: "+ account.getBalance());
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
