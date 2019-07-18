package com.thread.test008;

import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/18 上午11:25
 */
public class Account {
    private String name;
    private double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    //没有加锁，可能产生脏读
    public double getBalance(String name) {

        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();

        new Thread(()->account.set("zs", 10)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zs"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zs"));

    }
}
