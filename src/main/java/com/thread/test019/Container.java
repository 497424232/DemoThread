package com.thread.test019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/18 下午2:21
 */
public class Container {

    volatile List list = new ArrayList();

    public void add (Object o) {
        list.add(o);
    }

    public int size () {
        return list.size();
    }

    public static void main(String[] args) {
        Container container = new Container();

        //使用门闩控制
        CountDownLatch latch = new CountDownLatch(1);

        //启动第一个线程
        new Thread(()->{
            System.out.println("t2 启动");
            if (container.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1 启动");

            for (int i = 0; i < 10; i++) {
                container.add(new Object());
                System.out.println("t1 add " + i);
                if (container.size() == 5) {
                    // 打开门闩，让t2继续执行
                    latch.countDown();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "t1").start();
    }
}
