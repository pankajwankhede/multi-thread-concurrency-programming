package com.xuliugen.demo.multithread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static ReentrantLock lock = new ReentrantLock();
    public Condition newCondition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        lock.lock();

        System.out.println("sout!");

        lock.unlock();
    }
}