package drivers;

import Runnables.DepositRunnable;
import Runnables.WithdrawRunnable;
import model.AccountADT;
import model.BasicAccount;
import model.Customer;
import model.SavingsAccount;

public class testDriverSavingsAcc {

    public static void main(String[] args) {

        //MODEL CLASSES
        Customer customer = new Customer("STEVE");
        Customer customer2 = new Customer("ELLIOT");

        AccountADT save1 = new SavingsAccount(1, 20000);
        customer.openAccount(save1);
        customer2.openAccount(save1);

        //RUNNABLES - Maybe pass customers here
        DepositRunnable r2 = new DepositRunnable(customer, save1, 100);
        WithdrawRunnable r1 = new WithdrawRunnable(customer2, save1, 100);

        //THREADS
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        //Execute threads
        int a = 0;
        t2.start();
        try {
            Thread.sleep(2000);
            customer2.viewBalance(save1);
        } catch (InterruptedException e) {
            System.out.println("thread sleep interrupted!!");
        }

        t1.start();
        try{
            Thread.sleep(2000);
        }catch(
                InterruptedException e){
            System.out.println("thread sleep interrupted!!");
        }

        System.out.println("ACTUAL BALANCE: "+save1.getBalance());

    }
}
