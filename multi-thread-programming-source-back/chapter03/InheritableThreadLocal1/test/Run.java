package chapter03.InheritableThreadLocal1.test;

import chapter03.InheritableThreadLocal1.extthread.ThreadA;
import chapter03.InheritableThreadLocal1.tools.Tools;

public class Run {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("       ��Main�߳���ȡֵ=" + Tools.tl.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
