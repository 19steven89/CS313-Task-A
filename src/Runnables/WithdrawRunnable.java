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
            System.out.println("Withdraw Thread: Balance is " + account.getBalance() + " at the start of the thread");
            customer.withdraw(account,amount);
            System.out.println("Withdraw Thread: Attempting to withdraw "+amount);
            System.out.println("Withdraw Thread: Balance is " + account.getBalance() + " at the end of the thread");
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
