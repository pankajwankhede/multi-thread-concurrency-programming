package chapter04.c4_2.c4_2_2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();

        new Thread(() -> demo.write(), "ThreadA").start();
        new Thread(() -> demo.write(), "ThreadB").start();
    }

    private void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName()
                        + " 时间:" + System.currentTimeMillis());
                //模拟写操作时间为5秒
                Thread.sleep(5000);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
