package chapter04.c4_1_8.extthread;

import chapter04.c4_1_8.service.MyService;

public class MyThreadA extends Thread {

    private MyService myService;

    public MyThreadA(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.set();
        }
    }

}
