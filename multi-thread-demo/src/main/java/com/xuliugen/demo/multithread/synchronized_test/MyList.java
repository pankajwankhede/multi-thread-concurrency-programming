package com.xuliugen.demo.multithread.synchronized_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyList {

    private List<String> myLists = new ArrayList<>();
    private ReentrantLock lock = new ReentrantLock(true);

    public synchronized void setList(String element) {
        myLists.add(element);
    }

    public synchronized void setList2(String element) {
        myLists.add(element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int getListSize() {
        return myLists.size();
    }
}
