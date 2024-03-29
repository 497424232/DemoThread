package com.thread.test026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @auther changmk
 * @date 2019/7/19 上午10:03
 */
public class Test_ThreadPool {
    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(service);

        service.shutdown();
        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
        System.out.println(service);

        TimeUnit.SECONDS.sleep(4);

        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
        System.out.println(service);
    }
}
