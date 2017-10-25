package com.xuliugen.demo.multithread.synchronized_test;

/**
 * Created by xuliugen on 2017/10/24.
 */
public class Synchronized {

    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        method();
    }

    public static synchronized void method() {
    }
}
