package com.thread.test012_volatile;

import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/18 下午12:15
 */
public class Test {

    volatile boolean running = true;

    void m () {
        System.out.println("m start");

        while (running) {

        }

        System.out.println("m end");
    }

    public static void main(String[] args) {
        Test test = new Test();

        new Thread(test::m, "test").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.running = false;
    }
}
