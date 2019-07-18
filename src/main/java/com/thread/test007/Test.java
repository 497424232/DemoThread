package com.thread.test007;

/**
 * @auther changmk
 * @date 2019/7/18 上午10:46
 */
public class Test{

    private static int count = 10;

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(()->test.m1(), "thread" + 1).start();
        new Thread(test::m2, "thread" + 2).start();

//        new Thread(test::m1, "thread" + 1).start();
//        new Thread(test::m2, "thread" + 2).start();

        //等同于下面写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.m1();
            }
        }).start();
    }

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end" );
    }

    public void m2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end" );
    }
}
