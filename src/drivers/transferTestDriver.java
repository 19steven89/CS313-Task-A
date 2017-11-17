package drivers;

import Runnables.DepositRunnable;
import Runnables.TransferRunnable;
import Runnables.WithdrawRunnable;
import model.AccountADT;
import model.BasicAccount;
import model.Customer;

public class transferTestDriver {
    public static void main(String[] args){

        //MODEL CLASSES
        Customer customerA = new Customer("STEVE");
        AccountADT basicA = new BasicAccount(1,500);
        customerA.openAccount(basicA);

        Customer customerB = new Customer("STEVE");
        AccountADT basicB = new BasicAccount(2,500);
        customerB.openAccount(basicB);


        //RUNNABLES - Maybe pass customers here
        TransferRunnable ta1 = new TransferRunnable(customerA,basicA,basicB,700.00);

        //THREADS
        Thread t1 = new Thread(ta1);

        //Execute threads
        t1.start();

        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.out.println("RREEEEEEEEEEEEEE");
        }
        System.out.println("ACTUAL BALANCE: " + basicA.getBalance());
        System.out.println("ACTUAL BALANCE: " + basicB.getBalance());


        //thread waits printing happens first as the main thread might output before the runnable thread resumes control

    }
}
