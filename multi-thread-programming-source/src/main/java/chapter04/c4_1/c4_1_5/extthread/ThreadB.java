package chapter04.c4_1.c4_1_5.extthread;

import chapter04.c4_1.c4_1_5.service.MyService;

public class ThreadB extends Thread {

    private MyService service;

    public ThreadB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
