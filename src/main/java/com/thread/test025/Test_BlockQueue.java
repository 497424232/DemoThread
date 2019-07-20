package com.thread.test025;

import sun.awt.windows.ThemeReader;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @auther changmk
 * @date 2019/7/18 下午9:58
 */
public class Test_BlockQueue {
    static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    static Random r = new Random();

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    //加满了会阻塞线程
                    queue.put(i + "");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " put " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p").start();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (;;){
                    try {
                        //队列中空了就会阻塞
                        String s = queue.take();
                        System.out.println(Thread.currentThread().getName() + "take " + s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();
        }
    }


}
