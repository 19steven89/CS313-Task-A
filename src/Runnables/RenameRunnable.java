package Runnables;

import model.AccountADT;
import model.Customer;

public class RenameRunnable implements Runnable {

    private static final int DELAY = 2;
    private AccountADT account;
    private Customer customer;
    private String newName;

    public RenameRunnable(Customer c,String n){
        newName = n;
        customer = c;
    }

    public void run(){
        try {
            customer.setName(newName);
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
