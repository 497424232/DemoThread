package com.thread.test021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther changmk
 * @date 2019/7/18 下午3:55
 */
public class Container1<T> {
    final private LinkedList<T> linkedList = new LinkedList<T>();
    final private int MAX = 10;
    int count = 0;

    ReentrantLock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();

    public void put(T t) {
        lock.lock();
        //不能用if，防止容器内数据超过max
        while (linkedList.size() == MAX) {
            try {
                producer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        linkedList.add(t);
        ++count;
        consumer.signalAll();
    }

    public T get() {
        T t = null;
        lock.lock();
        while (linkedList.size() == 0) {
            try {
                consumer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = linkedList.removeFirst();
        --count;
        producer.signalAll();
        return t;
    }

    public static void main(String[] args) {
        Container1<String> container = new Container1<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(container.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 20; j++) {
                    container.put(Thread.currentThread().getName()+ " " + j);
                }
            }, "p" + i).start();
        }

    }

}
