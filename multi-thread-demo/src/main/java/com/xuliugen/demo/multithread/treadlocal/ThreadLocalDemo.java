package com.xuliugen.demo.multithread.treadlocal;

public class ThreadLocalDemo {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public void setThreadLocal(String value) {
        threadLocal.set(value);
    }

    public void getThreadLocal() {
        System.out.println(Thread.currentThread().getName() + ":" + this.threadLocal.get());
    }

    public static void main(String[] args) throws InterruptedException {

        final ThreadLocalDemo ct = new ThreadLocalDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.setThreadLocal("张三");
                ct.getThreadLocal();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    //ct.setThreadLocal("李四");
                    ct.getThreadLocal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
