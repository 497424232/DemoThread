package com.thread.test015_Atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther changmk
 * @date 2019/7/18 下午1:11
 */
public class Test {

//    volatile int count = 0;

    AtomicInteger count = new AtomicInteger(0);

    void m(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new Thread(test::m, "t"+i));
        }

        list.forEach((o)->o.start());

        list.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(test.count);
    }
}
