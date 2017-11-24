package Runnables;

import model.AccountADT;
import model.Customer;

public class RenameRunnable implements Runnable {

    private static final int DELAY = 2;
    private AccountADT account;
    private Customer customer;
    private String newID;

    public RenameRunnable(Customer c,String n){
        newID = n;
        customer = c;
    }

    public void run(){
        try {
            customer.setCustID(newID);
            System.out.println("New Customer ID: " + customer.getCustID());
            Thread.sleep(DELAY);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
