package com.thread.test022;

import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/18 下午4:32
 */
public class ThreadLocal1 {
    static ThreadLocal<Person> threadLocal = new ThreadLocal<Person>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person());
        }).start();



    }
}

class Person{
    String name = "ls";
}