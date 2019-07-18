package com.thread.test011;

import java.util.concurrent.TimeUnit;

/**
 *
 * @auther changmk
 * @date 2019/7/18 上午10:46
 */
public class Test {

    private static int count = 10;

    public static void main(String[] args) {
        Test test = new Test();

        Runnable r = () -> test.m();

        new Thread(r, "thread" + 1).start();
        try {
            TimeUnit.SECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "thread" + 2).start();

    }

    public synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        int count = 0;
        while (true) {
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " count " + count);
            //todo 遇到异常后，线程会释放锁，这里没有看到
            if (count == 5) {
                int i = 1 / 0;
            }
        }


    }

}
