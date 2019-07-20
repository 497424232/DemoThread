package com.thread.test025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @auther changmk
 * @date 2019/7/18 下午9:51
 */
public class Test_ConcurrentQueue {

    public static void main(String[] args) {
        //单向列表
        Queue<String> list = new ConcurrentLinkedQueue<>();
        //双向列表
        Queue<String> queue = new ConcurrentLinkedDeque<>();

        for (int i = 0; i < 10; i++) {
            list.offer("a" + i);
        }

        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.poll());
        System.out.println(list.size());

        System.out.println(list.peek());
        System.out.println(list.size());
    }
}
