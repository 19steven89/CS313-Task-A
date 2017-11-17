package drivers;

import Runnables.BalanceRunnable;
import Runnables.DepositRunnable;
import Runnables.WithdrawRunnable;
import model.*;

public class EmployeeSetName {


    public static void main(String[] args){
        //objects and initialisers
        AccountADT save1;
        Customer cust1, cust2;
        Employee em1,em2;

        save1 = new SavingsAccount(9011, 0);
        cust1 = new Customer("Elliot");
        em1 = new Employee();
        em2 = new Employee();

        em1.changeCustName(cust1,"ELLIOT THE GOD");
        em2.changeCustName(cust1,"ELLIOT THE LOSER");




    }
}
