package Runnables;

import model.AccountADT;
import model.Customer;

public class BalanceRunnable implements Runnable {

    private static final int DELAY = 1;
    private AccountADT account;

    public BalanceRunnable(AccountADT a){
        account = a;
    }

    public void run(){
        try {
            System.out.println("Current balance of account : " + account.getAccountID() + " is : " + account.getBalance());
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
