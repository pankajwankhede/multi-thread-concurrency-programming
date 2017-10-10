package chapter04.c4_1_4.test;

import chapter04.c4_1_4.extthread.ThreadA;
import chapter04.c4_1_4.service.MyService;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        MyService service = new MyService();
        new ThreadA(service).start();
        Thread.sleep(3000);
        service.signal();
    }
}
