package com.thread.test005;

/**
 * @auther changmk
 * @date 2019/7/18 上午10:46
 */
public class Test implements Runnable{

    private static int count = 10;

    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0; i< 10 ; i++) {
            new Thread(test, "thread" + i).start();
        }
    }

    @Override
    public synchronized void run() {
        count --;
        System.out.println(Thread.currentThread().getName() + ".count=" + count);
    }
}
