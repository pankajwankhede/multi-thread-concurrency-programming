package chapter04.c4_1_5.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitAB时间为 " + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
            condition.await();
            System.out.println("  end awaitAB时间为 " + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB时间为 " + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
            condition.await();
            System.out.println("  end awaitB时间为 " + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 因为只有一个condition则会通知所有的
     */
    public void signalAll() {
        try {
            lock.lock();
            System.out.println("  signalAll时间为 " + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
