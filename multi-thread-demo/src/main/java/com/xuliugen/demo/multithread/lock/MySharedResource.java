package com.xuliugen.demo.multithread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xuliugen on 2017/10/28.
 */
public class MySharedResource {

    public static void main(String[] args) {

        final ReadWriteLockDemo lockDemo = new ReadWriteLockDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                System.out.println("taskId:" + index);
                while (true) {
                    if (0 == (index % 2)) {
                        lockDemo.downgrade(index);
                    } else {
                        lockDemo.read(index);
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
