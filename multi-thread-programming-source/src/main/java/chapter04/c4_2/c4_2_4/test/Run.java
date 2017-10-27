package chapter04.c4_2.c4_2_4.test;

import chapter04.c4_2.c4_2_4.extthread.ThreadA;
import chapter04.c4_2.c4_2_4.extthread.ThreadB;
import chapter04.c4_2.c4_2_4.service.Service;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        Service service = new Service();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(1000);

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

    }

}
