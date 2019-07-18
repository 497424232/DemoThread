package com.thread.test021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/18 下午3:55
 */
public class Container<T> {
    final private LinkedList<T> linkedList = new LinkedList<T>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        //不能用if，防止容器内数据超过max
        while (linkedList.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        linkedList.add(t);
        ++count;
        //防止叫醒的线程是生产者，然后wait
        this.notifyAll();//通知消费者线程进行消费
    }

    public synchronized T get() {
        T t = null;
        while (linkedList.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = linkedList.removeFirst();
        --count;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        Container<String> container = new Container<>();

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
