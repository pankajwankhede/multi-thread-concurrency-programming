package chapter04.c4_2.c4_2_1.test;

import chapter04.c4_2.c4_2_1.extthread.ThreadA;
import chapter04.c4_2.c4_2_1.extthread.ThreadB;
import chapter04.c4_2.c4_2_1.service.Service;

public class Run {

    public static void main(String[] args) {

        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");

        ThreadB b = new ThreadB(service);
        b.setName("B");

        a.start();
        b.start();
    }
}
