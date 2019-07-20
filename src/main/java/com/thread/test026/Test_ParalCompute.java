package com.thread.test026;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @auther changmk
 * @date 2019/7/19 上午10:38
 */
public class Test_ParalCompute {
    public static void main(String[] args) throws Exception{

        ExecutorService service = Executors.newFixedThreadPool(4);

        MyTask myTask1 = new MyTask(1, 300);
        MyTask myTask2 = new MyTask(1, 300);
        MyTask myTask3 = new MyTask(1, 300);
        MyTask myTask4 = new MyTask(1, 300);

        Future<Integer> future1 = service.submit(myTask1);
        Future<Integer> future2 = service.submit(myTask2);
        Future<Integer> future3 = service.submit(myTask3);
        Future<Integer> future4 = service.submit(myTask4);

        future1.get();
        future2.get();
        future3.get();
        future4.get();

    }
}

class MyTask implements Callable<Integer>{

    int startNum;
    int endNum;

    public MyTask(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public Integer call() throws Exception {

        return startNum + endNum;
    }
}