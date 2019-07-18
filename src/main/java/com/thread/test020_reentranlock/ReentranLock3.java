package com.thread.test020_reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther changmk
 * @date 2019/7/18 下午3:06
 */
public class ReentranLock3 {

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
//        boolean locked = lock.tryLock();
//        System.out.println("m2-----" + locked);
//        lock.unlock();

        boolean locked = false;
        try {
            locked = lock.tryLock(4, TimeUnit.SECONDS);

            //可以设置lock为可打断的
            //可以在主线程中调用interrupt方法打断，然后当做异常处理
//            lock.lockInterruptibly();

            System.out.println(locked);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentranLock3 r2 = new ReentranLock3();

        new Thread(r2::m1, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->r2.m2(), "t2").start();
    }
}
