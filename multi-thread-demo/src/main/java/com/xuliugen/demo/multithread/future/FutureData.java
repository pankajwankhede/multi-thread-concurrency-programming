package com.xuliugen.demo.multithread.future;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Future数据，构造很快，但是是一个虚拟的数据，需要装配RealData
 * Created by xuliugen on 2017/10/22.
 */
public class FutureData implements Data {

    private RealData realData = null;
    private boolean isReady = false;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Override
    public String getResult() {
        lock.lock();
        while (!isReady) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
        return realData.getResult();
    }

    public void setRealData(RealData realData) {
        lock.lock();
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        condition.signal();
        lock.unlock();
    }
}
