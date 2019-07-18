package com.thread.test020_reentranlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther changmk
 * @date 2019/7/18 下午3:06
 */
public class ReentranLock4 {
    Lock lock = new ReentrantLock();

    void m() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            if (lock.)
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentranLock4 r4 = new ReentranLock4();
        Thread thread = new Thread(r4::m, "t");
        thread.start();
        thread.interrupt();
    }
}
