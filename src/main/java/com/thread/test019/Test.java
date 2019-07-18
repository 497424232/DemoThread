package com.thread.test019;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther changmk
 * @date 2019/7/18 下午2:18
 */
public class Test {

    volatile List list = new ArrayList();

    public void add (Object o) {
        list.add(o);
    }

    public int size () {
        return  list.size();
    }


}
