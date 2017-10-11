package chapter04.c4_2.c4_2_1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();

        new Thread(() -> demo.read(), "ThreadA").start();
        new Thread(() -> demo.read(), "ThreadB").start();
    }

    private void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " 时间:" + System.currentTimeMillis());
                //模拟读操作时间为5秒
                Thread.sleep(5000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
