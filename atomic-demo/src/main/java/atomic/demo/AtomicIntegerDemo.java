package atomic.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xuliugen on 2017/10/21.
 */
public class AtomicIntegerDemo {

    private static AtomicInteger integer = new AtomicInteger();

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(integer.incrementAndGet());
                }
            }
        }).start();
    }
}
