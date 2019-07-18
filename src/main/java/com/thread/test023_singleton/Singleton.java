package com.thread.test023_singleton;

/**
 * 静态方法，不加锁，实现懒加载
 *
 * @auther changmk
 * @date 2019/7/18 下午8:45
 */
public class Singleton {

    private Singleton() {

    }

    private static class InnerClass {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerClass.singleton;
    }

}
