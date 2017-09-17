package com.xuliugen.demo.multithread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by xuliugen on 2017/9/10.
 */
public class Tickets {

    public static void main(String[] args) {

        //1、避免线程同步可采用Vector替代ArrayList或者HashTable替代HashMap
        final Vector<String> tickets = new Vector<String>();

        Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());

        //2、初始化火车票池并添加火车票
        for (int i = 1; i < 50; i++) {
            tickets.add("火车票" + i);
        }

        for (int i = 1; i < 5; i++) {
            new Thread("线程" + i) {
                @Override
                public void run() {
                    while (true) {
                        if (tickets.isEmpty()) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "---" + tickets.remove(0));
                    }
                }
            }.start();
        }
    }
}
