package com.thread.test026;

import java.util.concurrent.Executor;

/**
 * @auther changmk
 * @date 2019/7/19 上午9:38
 */
public class test1_Excutor implements Executor {

    public static void main(String[] args) {
        new test1_Excutor().execute(()->System.out.println("hello"));
    }

    @Override
    public void execute(Runnable command) {
//        new Thread(command).run();
        command.run();
    }
}
