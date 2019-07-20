package com.thread.test025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/18 下午10:13
 */
public class Test_ArrayBlockingQueue {
    static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

    static Random r = new Random();

    public static void main(String[] args)throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            queue.put(i+"");
        }

        queue.put("10");
        queue.add("10");
        boolean bo = queue.offer("10");
        boolean boo = queue.offer("10", 1, TimeUnit.SECONDS);
    }
}
