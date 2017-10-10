package chapter04.c4_1_7.test;

import chapter04.c4_1_7.extthread.MyThreadA;
import chapter04.c4_1_7.extthread.MyThreadB;
import chapter04.c4_1_7.service.MyService;

/**
 * 实现生产者/消费者模式：一对一交替打印
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();

        MyThreadA a = new MyThreadA(myService);
        a.start();

        MyThreadB b = new MyThreadB(myService);
        b.start();

    }
}
