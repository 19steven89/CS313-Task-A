package drivers;

import Runnables.DepositRunnable;
import Runnables.WithdrawRunnable;
import model.Bank;
import model.Customer;

public class TestFive {
    public static void main(String[] args){

        Bank bank = new Bank();

        Customer aa = new Customer("AA0001");
        Customer bb = new Customer("AA0001");

        bank.openBasic(aa);

        Thread t1 = new Thread(new WithdrawRunnable(bank.getAccount(bb,1),100));
        Thread t2 = new Thread(new DepositRunnable(bank.getAccount(aa,1),200));

        //Check withdrawing with insufficient funds!
        t1.start();
        t2.start();
    }
}
