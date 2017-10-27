package chapter04.c4_1.c4_1_1;

public class MyThread extends Thread {

    private MyService service;

    MyThread(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
