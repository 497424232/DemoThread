package com.thread.test003;

/**
 * @auther changmk
 * @date 2019/7/18 上午10:46
 */
public class Test {

    private int count = 10;

    public synchronized void m(){   //等同于test002下方法的代码上要执行synchronized(this)
        count --;
        System.out.println(Thread.currentThread().getName() + ".count=" + count);
    }

    public static void main(String[] args) {

    }
}
