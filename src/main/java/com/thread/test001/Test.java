package com.thread.test001;

/**
 * @auther changmk
 * @date 2019/7/18 上午10:46
 */
public class Test {

    private int count = 10;
    private Object o = new Object();

    public void m(Object o){
        synchronized(o) {   //任何线程要执行下面的代码，必须要拿到o的锁
            count --;
            System.out.println(Thread.currentThread().getName() + ".count=" + count);
        }
    }

    public static void main(String[] args) {

    }
}
