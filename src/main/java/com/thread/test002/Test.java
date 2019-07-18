package com.thread.test002;

/**
 * @auther changmk
 * @date 2019/7/18 上午10:46
 */
public class Test {

    private int count = 10;

    public void m(){
        synchronized(this) {   //任何线程要执行下面的代码，必须要拿到this的锁
            count --;
            System.out.println(Thread.currentThread().getName() + ".count=" + count);
        }
    }

    public static void main(String[] args) {

    }
}
