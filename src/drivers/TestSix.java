package drivers;

import Runnables.BalanceRunnable;
import Runnables.DepositRunnable;
import Runnables.RenameRunnable;
import model.Bank;
import model.Customer;

public class TestSix {
    public static void main(String[] args){

        Bank bank = new Bank();

        Customer aa = new Customer("AA0001");
        Customer bb = new Customer("AA0001");

        bank.openBasic(aa);

        Thread t1 = new Thread(new RenameRunnable(aa,"BB0001"));
        Thread t2 = new Thread(new RenameRunnable(aa,"CC0001"));

        //Rename a user! Is this a race condition? It is but shouldn't it be?
        t1.start();
        t2.start();
    }
}
