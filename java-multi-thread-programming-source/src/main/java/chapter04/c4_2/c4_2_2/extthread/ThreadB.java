package chapter04.c4_2.c4_2_2.extthread;

import chapter04.c4_2.c4_2_2.service.Service;

public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
