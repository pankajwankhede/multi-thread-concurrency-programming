package chapter04.c4_1.c4_1_3.extthread;

import chapter04.c4_1.c4_1_3.service.MyService;

public class ThreadA extends Thread {

    private MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
