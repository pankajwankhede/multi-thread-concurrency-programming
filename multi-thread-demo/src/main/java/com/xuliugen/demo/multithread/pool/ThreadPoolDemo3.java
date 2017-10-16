package com.xuliugen.demo.multithread.pool;

import java.util.concurrent.*;

/**
 * 错误信息如果使用submit则无法显示，一种方式是放弃使用submit，另一种是可以使用execute
 */
public class ThreadPoolDemo3 {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), Executors.defaultThreadFactory());

        for (int i = 0; i < 5; i++) {
            int index = i;
            pool.submit(() -> divTask(100, index));

            Future future = pool.submit(() -> divTask(100, index));
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    private static void divTask(int a, int b) {
        double result = a / b;
        System.out.println(result);
    }
}
