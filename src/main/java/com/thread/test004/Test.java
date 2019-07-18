package com.thread.test004;

/**
 * @auther changmk
 * @date 2019/7/18 上午10:46
 */
public class Test {

    private static int count = 10;

    public synchronized static void m(){   //等同于要执行synchronized(Test.class)
        count --;
        System.out.println(Thread.currentThread().getName() + ".count=" + count);
    }

    public  static void mm(){
        synchronized(Test.class) {  //这里不能用synchronized(this)，因为静态方法不创建对象，this指的当前类的实例对象
            count --;
            System.out.println(Thread.currentThread().getName() + ".count=" + count);
        }
    }

}
