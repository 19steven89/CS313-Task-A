package drivers;

import Runnables.BalanceRunnable;
import model.AccountADT;
import model.BasicAccount;
import model.Customer;
import model.SavingsAccount;

public class TestDriverBalanceCheck {

    //2 sepertate acc checking balance on seperate threads at the same time
    //those 2 cust will have a shared acc and will check that acc at the same time


    public static void main(String[] args){
        //objects and initialisers
        AccountADT save1;
        AccountADT basic1, basic2;
        Customer cust1, cust2;
        save1 = new SavingsAccount(9011, 0);
        basic1 = new BasicAccount(8011, 0);
        basic2 = new BasicAccount(7011, 0);
        cust1 = new Customer("Elliot");
        cust2 = new Customer("Mark");

        cust1.openAccount(basic1);
        cust2.openAccount(basic2);
        cust1.openAccount(save1);
        cust2.openAccount(save1);


        BalanceRunnable r1 = new BalanceRunnable(cust1, basic1);
        BalanceRunnable r2 = new BalanceRunnable(cust2, basic2);
        BalanceRunnable r3 = new BalanceRunnable(cust1, save1);
        BalanceRunnable r4 = new BalanceRunnable(cust2, save1);
        //THREADS
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
