package com.xuliugen.demo.multithread;

/**
 * Created by xuliugen on 2017/9/15.
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "t1");
        thread.start();
    }
}
