package com.thread.test024_concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @auther changmk
 * @date 2019/7/18 下午9:04
 */
public class Ticket {

    static Queue<String> tickets = new ConcurrentLinkedQueue();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号：" +i);
        }
    }

    public static void main(String[] args) {

//        Collections.synchronizedMap()
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true) {
                    //因为这个操作没有重新对tickets赋值，所以可以通过不加锁可以实现，大大提高了执行效率
                    String s = tickets.poll();
                    if (s == null) break;
                    else System.out.println("销售了----" + s);
                }

            }).start();
        }
    }
}
