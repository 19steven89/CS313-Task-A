package model;

import Runnables.BalanceRunnable;
import Runnables.DepositRunnable;
import Runnables.WithdrawRunnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {
    private List<AccountADT> bank;

    public Bank(){
        bank = Collections.synchronizedList(new ArrayList<>());
    }

    public static void main(String[] args){

        Bank bank = new Bank();

        Customer aa = new Customer("AA0001");
        Customer bb = new Customer("BB0001");

        bank.openBasic(aa);
        bank.openBasic(bb);
        bank.openSavings(aa,bb);

        Thread t1 = new Thread(new DepositRunnable(bank.getAccount(bb,1),100));
        Thread t2 = new Thread(new DepositRunnable(bank.getAccount(bb,1),100));
        Thread t3 = new Thread(new WithdrawRunnable(bank.getAccount(bb,1),600));
        Thread t4 = new Thread(new DepositRunnable(bank.getAccount(bb,1),500));
        Thread t5 = new Thread(new BalanceRunnable(bank.getAccount(bb,1)));
        Thread t6 = new Thread(new BalanceRunnable(bank.getAccount(bb,1)));

        t2.start();
        t3.start();
        t4.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t5.start();
        t6.start();
        t1.start();

    }

    public void openBasic(Customer customer){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10000 + 1);
        AccountADT account = new BasicAccount(customer.getCustID(),randomNum,0.0);
        bank.add(account);
    }

    public void openCurrent(Customer customer){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10000 + 1);
        AccountADT account = new CurrentAccount(customer.getCustID(),randomNum,0.0);
        bank.add(account);
    }

    public void openSavings(Customer customerA, Customer customerB){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10000 + 1);
        AccountADT account = new SavingsAccount(customerA.getCustID(), customerB.getCustID(),randomNum,0.0);
        bank.add(account);
    }

    public void closeAccount(AccountADT account){
        int index = 0;
        index = bank.indexOf(account);
        bank.remove(index);
    }

    public AccountADT getAccount(Customer customer, int type){
        AccountADT account = new BasicAccount("0000",0000,0);

        for(AccountADT a : getBank()){
            if(a.getCustomerID().equals(customer.getCustID()) && a.getType() == type){
                return a;
            }
        }
        return account;
    }

    public List<AccountADT> getBank(){
        return bank;
    }

}
