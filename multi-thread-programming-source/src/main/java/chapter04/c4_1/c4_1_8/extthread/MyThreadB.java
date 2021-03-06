package chapter04.c4_1.c4_1_8.extthread;

import chapter04.c4_1.c4_1_8.service.MyService;

public class MyThreadB extends Thread {

    private MyService myService;

    public MyThreadB(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.get();
        }
    }

}
