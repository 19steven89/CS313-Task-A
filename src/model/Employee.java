package model;

import Runnables.DepositRunnable;
import Runnables.RenameRunnable;
import Runnables.WithdrawRunnable;

public class Employee {

    public Employee(){

    }

    public void custViewBalance(Customer cust, AccountADT account){
        System.out.println("EMPLOYEE ACCESS: \n" + cust.viewBalance(account));
    }

    public void custSetBalance(AccountADT account, Customer cust1, double amount){
        WithdrawRunnable wr = new WithdrawRunnable(cust1,account, account.getBalance());
        Thread t1 = new Thread(wr);
        t1.start();
        DepositRunnable dr = new DepositRunnable(cust1,account, amount);
        Thread t2 = new Thread(dr);
        t2.start();
    }

    public void changeCustName(Customer customer, String name){
        RenameRunnable rr = new RenameRunnable(customer,name);
        Thread t1 = new Thread(rr);
        t1.start();
    }

    public void standingOrderIn(Customer customer, AccountADT accountADT, double amount){
        System.out.println("EMPLOYEE ACCESS: \n");
        DepositRunnable dr = new DepositRunnable(customer,accountADT, amount);
        Thread t1 = new Thread(dr);
        t1.start();
    }

    public void standingOrderOut(Customer customer, AccountADT accountADT, double amount){
        System.out.println("EMPLOYEE ACCESS: \n");
        WithdrawRunnable wr = new WithdrawRunnable(customer,accountADT, amount);
        Thread t1 = new Thread(wr);
        t1.start();
    }

    public int getAccountID(AccountADT account){

        return account.getAccountId();
    }
}





