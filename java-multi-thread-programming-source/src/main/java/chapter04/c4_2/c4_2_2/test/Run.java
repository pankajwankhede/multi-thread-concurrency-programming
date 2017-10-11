package chapter04.c4_2.c4_2_2.test;

import chapter04.c4_2.c4_2_2.extthread.ThreadA;
import chapter04.c4_2.c4_2_2.extthread.ThreadB;
import chapter04.c4_2.c4_2_2.service.Service;

public class Run {

    public static void main(String[] args) {

        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("ThreadA");
        ThreadB b = new ThreadB(service);
        b.setName("ThreadB");
        a.start();
        b.start();
    }
}
