package chapter03.c3_1_3.test2.extthread;

public class MyThread1 extends Thread {

    private Object lock;

    public MyThread1(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始      wait time=" + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束      wait time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
