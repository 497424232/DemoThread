package com.thread.test020_reentranlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 * @auther changmk
 * @date 2019/7/18 下午3:06
 */
public class ReentranLock5 extends Thread{

    private static ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " count " + i);
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        ReentranLock5 r5 = new ReentranLock5();

        Thread t1 = new Thread(r5);
        Thread t2 = new Thread(r5);
        Thread t3 = new Thread(r5);

        t1.start();
        t2.start();
    }

}
