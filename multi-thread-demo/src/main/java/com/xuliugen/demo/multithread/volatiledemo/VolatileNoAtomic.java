package com.xuliugen.demo.multithread.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xuliugen on 2017/9/10.
 */
public class VolatileNoAtomic extends Thread {

    private static AtomicInteger count = new AtomicInteger(0);

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        VolatileNoAtomic[] arr = new VolatileNoAtomic[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new VolatileNoAtomic();
        }

        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }
}
