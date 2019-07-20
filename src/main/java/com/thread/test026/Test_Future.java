package com.thread.test026;

import java.util.concurrent.*;

/**
 * @auther changmk
 * @date 2019/7/19 上午10:14
 */
public class Test_Future {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start();

        System.out.println(task.get());//阻塞线程得到，如果拿不到值就一直阻塞

        //todo 处理ExecutorService submit方法错误
        ExecutorService service = Executors.newFixedThreadPool(5);
//        FutureTask<Integer> future = service.submit(()->{
//            TimeUnit.MILLISECONDS.sleep(500);
//            return 1000;
//        });
//
//        System.out.println(future.get());
//        System.out.println(future.isDone());

    }

}
