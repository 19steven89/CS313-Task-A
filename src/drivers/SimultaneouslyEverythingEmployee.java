package drivers;

import Runnables.BalanceRunnable;
import Runnables.DepositRunnable;
import Runnables.WithdrawRunnable;
import model.AccountADT;
import model.Customer;
import model.Employee;
import model.SavingsAccount;

public class SimultaneouslyEverythingEmployee {
    public static void main(String[] args){
        //objects and initialisers
        AccountADT save1;
        AccountADT basic1, basic2;
        Customer cust1, cust2;
        save1 = new SavingsAccount(9011, 0);
        cust1 = new Customer("Elliot");
        cust2 = new Customer("Mark");
        Employee em1 = new Employee();

        cust1.openAccount(save1);
        cust2.openAccount(save1);

        DepositRunnable r1 = new DepositRunnable(cust1, save1, 100);
        WithdrawRunnable r2 = new WithdrawRunnable(cust2, save1, 100);
        BalanceRunnable r3 = new BalanceRunnable(cust1, save1);
        BalanceRunnable r4 = new BalanceRunnable(cust2, save1);

        //THREADS
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        t3.start();
        t1.start();
        em1.standingOrderIn(cust1,save1,100);
        t2.start();
        em1.custViewBalance(cust1,save1);
        t4.start();
        em1.standingOrderOut(cust1,save1,100);
        em1.custViewBalance(cust1,save1);


    }
}
