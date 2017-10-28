package com.xuliugen.demo.multithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    private int x = 0;

    //公平锁
    private ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.readLock();

    public void read(int index) {
        readLock.lock();
        for (int i = 0; i < 10; i++) {
            x--;
            System.out.println(index + "," + i + ": read called: x:" + x + " , " + Thread.currentThread().getName());
        }
        readLock.unlock();
    }

    public void downgrade(int index) {
        //持有写锁
        writeLock.lock();
        System.out.println(index + " writeLock locked.");

        try {
            for (int i = 0; i < 10; i++) {
                x++;
                System.out.println(index + "," + i + ": write called: x:" + x + " , " + Thread.currentThread().getName());
                //Thread.sleep(100);
            }

            //在已经持有写锁的情况下继续持有读锁
            readLock.lock();
            System.out.println(index + " writeLock ->  readLock locked.");
            //释放写锁后，降级为读锁
            writeLock.unlock();
            System.out.println(index + " writeLock unlocked.");

            for (int i = 0; i < 10; i++) {
                x++;
                System.out.println(index + "," + i + ": read in write: x:" + x + " , " + Thread.currentThread().getName());
                //Thread.sleep(1000);
            }
            //释放读锁
            readLock.unlock();
            System.out.println(index + " readLock locked.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.lock();
            writeLock.unlock();
        }
    }

}


