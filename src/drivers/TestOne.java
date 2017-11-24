package drivers;

import Runnables.BalanceRunnable;
import Runnables.DepositRunnable;
import model.Bank;
import model.Customer;

public class TestOne {
    public static void main(String[] args){

        Bank bank = new Bank();

        Customer aa = new Customer("AA0001");
        Customer bb = new Customer("AA0001");

        bank.openBasic(aa);

        Thread t1 = new Thread(new DepositRunnable(bank.getAccount(bb,1),100));
        Thread t2 = new Thread(new BalanceRunnable(bank.getAccount(aa,1)));
        Thread t3 = new Thread(new BalanceRunnable(bank.getAccount(bb,1)));

        //Check Balance Simultaneously
        t1.start();
        t2.start();
        t3.start();
    }

}
