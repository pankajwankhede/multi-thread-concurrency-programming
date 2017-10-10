package chapter04.c4_1_3.test;

import chapter04.c4_1_3.extthread.ThreadA;
import chapter04.c4_1_3.service.MyService;

public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();
        new ThreadA(service).start();
    }

}
