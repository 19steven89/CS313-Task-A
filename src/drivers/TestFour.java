package drivers;

import Runnables.BalanceRunnable;
import Runnables.DepositRunnable;
import Runnables.WithdrawRunnable;
import model.Bank;
import model.Customer;
import model.Employee;

public class TestFour {
    public static void main(String[] args){

        Bank bank = new Bank();

        Customer aa = new Customer("AA0001");
        Customer bb = new Customer("AA0001");
        Employee ee = new Employee();

        bank.openCurrent(aa);

        Thread t1 = new Thread(new DepositRunnable(bank.getAccount(bb,2),99));
        Thread t2 = new Thread(new DepositRunnable(bank.getAccount(aa,2),100));
        Thread t3 = new Thread(new WithdrawRunnable(bank.getAccount(bb,2),300));
        Thread t4 = new Thread(new WithdrawRunnable(bank.getAccount(aa,2),102));
        Thread t5 = new Thread(new BalanceRunnable(bank.getAccount(aa,2)));
        Thread t6 = new Thread(new BalanceRunnable(bank.getAccount(bb,2)));

        //Withdraw/Deposit and then view balance all whilst an employee does stuff!
        t1.start();
        t2.start();
        ee.standingOrderIn(bank.getAccount(aa,2),101);
        t3.start();
        t4.start();
        ee.standingOrderOut(bank.getAccount(aa,2),200);
        t5.start();
        t6.start();
    }
}
