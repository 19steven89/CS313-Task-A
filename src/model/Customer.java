package model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Customer{

    private String customerID;
    private Lock nameLock;
    private Condition nameCondition;

    public Customer(String customerID){

        nameLock = new ReentrantLock();
        nameCondition = nameLock.newCondition();
        setCustID(customerID);
    }

    public void setCustID(String customerID){
        nameLock.lock();
        String tempName = getCustID();
        try {
            this.customerID = customerID;
            if(tempName != null) {
                System.out.println("Name changed from : " + tempName + " to " + customerID);
            }
        }finally {
            nameCondition.signalAll();
            nameLock.unlock();
        }
    }

    public String getCustID() {
        nameLock.lock();
        try {
            return customerID;
        } finally {
            nameCondition.signalAll();
            nameLock.unlock();
        }
    }

}
