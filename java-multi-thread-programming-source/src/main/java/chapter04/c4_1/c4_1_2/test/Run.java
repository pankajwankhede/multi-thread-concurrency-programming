package chapter04.c4_1.c4_1_2.test;

import chapter04.c4_1.c4_1_2.extthread.ThreadA;
import chapter04.c4_1.c4_1_2.extthread.ThreadAA;
import chapter04.c4_1.c4_1_2.extthread.ThreadB;
import chapter04.c4_1.c4_1_2.extthread.ThreadBB;
import chapter04.c4_1.c4_1_2.service.MyService;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadAA aa = new ThreadAA(service);
        aa.setName("AA");
        aa.start();

        Thread.sleep(100);

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        ThreadBB bb = new ThreadBB(service);
        bb.setName("BB");
        bb.start();

    }

}
