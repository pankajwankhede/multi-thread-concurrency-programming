package chapter04.c4_1_5.test;

import chapter04.c4_1_5.extthread.ThreadA;
import chapter04.c4_1_5.extthread.ThreadB;
import chapter04.c4_1_5.service.MyService;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(3000);
        service.signalAll();
    }
}
