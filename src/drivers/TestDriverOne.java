package drivers;

import Runnables.DepositRunnable;
import Runnables.WithdrawRunnable;
import model.AccountADT;
import model.BasicAccount;
import model.Customer;

/**
 * TODO
 * Finish other account classes
 * Work on employee and customer selecting account they want
 * Making sure accounts are unique and we can get them
 * Finish Runnable Classes
 * Work on driver(s)
 * Work towards synchronization
 *
 */

public class TestDriverOne{
    public static void main(String[] args){

        //MODEL CLASSES
        Customer customer = new Customer("STEVE");
        AccountADT basic = new BasicAccount(1,500);
        customer.openAccount(basic);

        //RUNNABLES - Maybe pass customers here
        WithdrawRunnable r1 = new WithdrawRunnable(customer,basic, 600);
        DepositRunnable r2 = new DepositRunnable(customer,basic, 300);

        //THREADS
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        //Execute threads
        t1.start();
        t2.start();
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.out.println("RREEEEEEEEEEEEEE");
        }
        System.out.println("ACTUAL BALANCE: " + basic.getBalance());


        //thread waits printing happens first as the main thread might output before the runnable thread resumes control

    }
}
