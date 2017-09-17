package com.xuliugen.demo.multithread.volatiledemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author alienware
 */
public class ListAdd2 {

    private volatile static List list = new ArrayList();

    public void add() {
        list.add("bjsxt");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {

        final ListAdd2 listAdd2 = new ListAdd2();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t1启动..");
                    for (int i = 0; i < 10; i++) {
                        listAdd2.add();
                        System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
                        Thread.sleep(500);
                        if (listAdd2.size() == 5) {
                            countDownLatch.countDown();
                            System.out.println("已经发出通知..");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2启动..");
                if (listAdd2.size() == 5) {
                    try {
                        countDownLatch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "收到通知线程停止..");
                    throw new RuntimeException();
                }
            }
        }, "t2");

        t2.start();
        t1.start();

    }

}
