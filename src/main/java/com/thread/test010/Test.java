package com.thread.test010;

import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/18 上午11:48
 */
public class Test {

    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Child().m();
    }

}

class Child extends Test{
    synchronized void m(){
        System.out.println("child start");
        super.m();
        System.out.println("child end");
    }
}
