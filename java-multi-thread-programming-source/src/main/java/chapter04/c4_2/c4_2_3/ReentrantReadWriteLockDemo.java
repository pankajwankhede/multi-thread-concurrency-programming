package chapter04.c4_2.c4_2_3;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();

        new Thread(() -> demo.read(), "ThreadA").start();
        Thread.sleep(1000);
        new Thread(() -> demo.write(), "ThreadB").start();
    }

    private void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " 时间:" + System.currentTimeMillis());
                Thread.sleep(3000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName()
                        + " 时间:" + System.currentTimeMillis());
                Thread.sleep(3000);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
