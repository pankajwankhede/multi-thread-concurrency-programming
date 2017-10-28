package com.xuliugen.demo.multithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by xuliugen on 2017/10/28.
 */
public class LockLower {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    private boolean update;

    public void processData() {
        readLock.lock(); //读锁获取
        if (!update) {
            readLock.unlock(); //必须先释放读锁
            writeLock.lock(); //锁降级从获取写锁开始
            try {
                if (!update) {
                    //准备数据流程（略）
                    update = true;
                }
                //获取读锁。在写锁持有期间获取读锁
                //此处获取读锁，是为了防止，当释放写锁后，又有一个线程T获取锁，对数据进行改变，
                //而当前线程下面对改变的数据无法感知。
                //如果获取了读锁，则线程T则被阻塞，直到当前线程释放了读锁，那个T线程才有可能获取写锁。
                readLock.lock();
            } finally {
                writeLock.unlock();//释放写锁
            }
            //锁降级完成
        }

        try {
            //使用数据的流程
        } finally {
            readLock.unlock(); //释放读锁
        }
    }
}
