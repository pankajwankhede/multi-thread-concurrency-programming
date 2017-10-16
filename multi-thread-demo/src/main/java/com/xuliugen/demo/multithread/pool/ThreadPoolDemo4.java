package com.xuliugen.demo.multithread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 直接使用ExecutorService pool = Executors.newFixedThreadPool(2);  pool.submit()也不会出现错误的堆栈信息
 * 错误信息如果使用submit则无法显示，一种方式是放弃使用submit，另一种是可以使用execute
 */
public class ThreadPoolDemo4 {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            int index = i;
            /*
             * 不会出现错误的堆栈信息
             */
            pool.submit(() -> divTask(100, index));

            //1、可以使用Future future = pool.submit();实现错误信息堆栈信息
            Future future = pool.submit(() -> divTask(100, index));
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            //2、可以使用pool.execute();实现错误信息堆栈信息
            pool.execute(() -> divTask(100, index));
        }
        pool.shutdown();
    }

    private static void divTask(int a, int b) {
        double result = a / b;
        System.out.println(result);
    }
}
