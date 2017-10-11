package chapter04.c4_2.c4_2_3.test;

import chapter04.c4_2.c4_2_3.extthread.ThreadA;
import chapter04.c4_2.c4_2_3.extthread.ThreadB;
import chapter04.c4_2.c4_2_3.service.Service;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        Service service = new Service();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        Thread.sleep(1000);

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

    }

}
