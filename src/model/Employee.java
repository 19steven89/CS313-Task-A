package model;

import Runnables.DepositRunnable;
import Runnables.RenameRunnable;
import Runnables.WithdrawRunnable;

public class Employee {

    public Employee(){

    }

    public void custViewBalance(AccountADT account){
        System.out.println("EMPLOYEE ACCESS: \n" + account.getBalance());
    }

    public void custSetBalance(AccountADT account, double amount){
        WithdrawRunnable wr = new WithdrawRunnable(account, account.getBalance());
        Thread t1 = new Thread(wr);
        t1.start();
        DepositRunnable dr = new DepositRunnable(account, amount);
        Thread t2 = new Thread(dr);
        t2.start();
    }

    public void changeCustName(Customer customer, String name){
        RenameRunnable rr = new RenameRunnable(customer,name);
        Thread t1 = new Thread(rr);
        t1.start();
    }

    public void standingOrderIn(AccountADT accountADT, double amount){
        DepositRunnable dr = new DepositRunnable(accountADT, amount);
        Thread t1 = new Thread(dr);
        t1.start();
    }

    public void standingOrderOut(AccountADT accountADT, double amount){
        WithdrawRunnable wr = new WithdrawRunnable(accountADT, amount);
        Thread t1 = new Thread(wr);
        t1.start();
    }

    public int getAccountID(AccountADT account){
        return account.getAccountID();
    }
}





