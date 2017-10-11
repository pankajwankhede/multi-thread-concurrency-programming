package chapter04.c4_2.c4_2_3.extthread;

import chapter04.c4_2.c4_2_3.service.Service;

public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }

}
