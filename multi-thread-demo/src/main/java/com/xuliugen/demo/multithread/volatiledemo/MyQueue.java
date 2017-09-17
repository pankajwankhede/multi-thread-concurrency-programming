package com.xuliugen.demo.multithread.volatiledemo;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟Queue
 * @author alienware
 */
public class MyQueue {

    //1、需要一个承装元素的集合
    private final LinkedList<Object> list = new LinkedList<Object>();
    //2、需要一个计数器
    private final AtomicInteger count = new AtomicInteger(0);
    //3、需要指定上限和下限
    private final int maxSize;
    private final int minSize = 0;

    //4、构造方法
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    //5、初始化锁对象
    private final Object lock = new Object();

    /**
     * put方法
     */
    public void put(Object obj) {
        synchronized (lock) {
            while (count.get() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(obj); //加入元素
            count.getAndIncrement(); //计数器增加
            System.out.println(" 元素 " + obj + " 被添加 ");
            lock.notify(); //通知另外一个阻塞的线程方法
        }
    }

    /**
     * take方法
     */
    public Object take() {
        Object temp = null;
        synchronized (lock) {
            while (count.get() == minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count.getAndDecrement();
            temp = list.removeFirst();
            System.out.println(" 元素 " + temp + " 被消费 ");
            lock.notify();
        }
        return temp;
    }

    public int size() {
        return count.get();
    }

    public static void main(String[] args) throws Exception {

        final MyQueue m = new MyQueue(5);
        m.put("a");
        m.put("b");
        m.put("c");
        m.put("d");
        m.put("e");
        System.out.println("当前元素个数：" + m.size());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.put("h");
                m.put("i");
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Object t1 = m.take();
                    //System.out.println("被取走的元素为：" + t1);
                    Thread.sleep(1000);
                    Object t2 = m.take();
                    //System.out.println("被取走的元素为：" + t2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        Thread.sleep(1000);
        t2.start();

    }


}
