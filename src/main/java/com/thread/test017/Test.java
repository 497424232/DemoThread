package com.thread.test017;

import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/18 下午1:22
 */
public class Test {

    Object o = new Object();

    void m() {
        synchronized(o) {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        //启动第一个线程
        new Thread(test::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //创建第二个线程
        Thread t2 = new Thread(()->test.m(), "t2");
        //锁对象发生改变，t2得以执行
        //如果注释掉这句话，t2将永远得不到执行机会
        test.o = new Object();
        //启动t2
        t2.start();
    }

}
