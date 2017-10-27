package chapter04.c4_1.c4_1_9.service;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock;

    public Service(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " 获得锁定");
        } finally {
            lock.unlock();
        }
    }

}
