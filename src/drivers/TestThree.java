package drivers;

import Runnables.BalanceRunnable;
import Runnables.DepositRunnable;
import Runnables.WithdrawRunnable;
import model.Bank;
import model.Customer;

public class TestThree {

    public static void main(String[] args){

        Bank bank = new Bank();

        Customer aa = new Customer("AA0001");
        Customer bb = new Customer("AA0001");

        bank.openBasic(aa);

        Thread t1 = new Thread(new DepositRunnable(bank.getAccount(bb,1),100));
        Thread t2 = new Thread(new DepositRunnable(bank.getAccount(aa,1),100));
        Thread t3 = new Thread(new WithdrawRunnable(bank.getAccount(bb,1),100));
        Thread t4 = new Thread(new WithdrawRunnable(bank.getAccount(aa,1),100));
        Thread t5 = new Thread(new BalanceRunnable(bank.getAccount(aa,1)));
        Thread t6 = new Thread(new BalanceRunnable(bank.getAccount(bb,1)));

        //Check Withdraw/Deposit and then view balance Simultaneously
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
