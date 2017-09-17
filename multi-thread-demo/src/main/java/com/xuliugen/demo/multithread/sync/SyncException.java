package com.xuliugen.demo.multithread.sync;

/**
 * Created by xuliugen on 2017/9/10.
 */
public class SyncException {

    private int i = 0;

    public synchronized void operation() {
        while (true) {
            try {
                i++;
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " , i= " + i);
                if (i == 10) {
                    Integer.parseInt("a");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("log info i = " + i);
            }
        }
    }

    public static void main(String[] args) {
        final SyncException se = new SyncException();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                se.operation();
            }
        }, "t1");
        t1.start();
    }
}
