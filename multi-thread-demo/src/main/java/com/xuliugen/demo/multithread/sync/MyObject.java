package com.xuliugen.demo.multithread.sync;

/**
 * Created by xuliugen on 2017/9/10.
 */
public class MyObject {

    public synchronized void method1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final MyObject myObject = new MyObject();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                myObject.method1();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                myObject.method2();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
