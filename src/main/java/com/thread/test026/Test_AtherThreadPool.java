package com.thread.test026;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @auther changmk
 * @date 2019/7/19 上午10:54
 */
public class Test_AtherThreadPool {

    public static void main(String[] args) {
        ExecutorService service0 = Executors.newFixedThreadPool(5);
        //
        ExecutorService service1 = Executors.newCachedThreadPool();

        ExecutorService service2 = Executors.newSingleThreadExecutor();
        //
        ExecutorService service3 = Executors.newScheduledThreadPool(5);
        //
        ExecutorService service4 = Executors.newWorkStealingPool();

        ForkJoinPool forkJoinPool = new ForkJoinPool();


    }
}
