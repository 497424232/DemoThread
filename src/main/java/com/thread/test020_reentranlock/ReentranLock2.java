package com.thread.test020_reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther changmk
 * @date 2019/7/18 下午3:06
 */
public class ReentranLock2 {

    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();//synchronized(this)
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        lock.lock();
        System.out.println("m2-----");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentranLock2 r2 = new ReentranLock2();

        new Thread(r2::m1, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->r2.m2(), "t2").start();
    }
}
