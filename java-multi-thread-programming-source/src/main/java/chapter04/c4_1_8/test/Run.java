package chapter04.c4_1_8.test;

import chapter04.c4_1_8.extthread.MyThreadA;
import chapter04.c4_1_8.extthread.MyThreadB;
import chapter04.c4_1_8.service.MyService;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        MyThreadA[] threadA = new MyThreadA[10];
        MyThreadB[] threadB = new MyThreadB[10];

        for (int i = 0; i < 10; i++) {
            threadA[i] = new MyThreadA(service);
            threadB[i] = new MyThreadB(service);
            threadA[i].start();
            threadB[i].start();
        }
    }
}
