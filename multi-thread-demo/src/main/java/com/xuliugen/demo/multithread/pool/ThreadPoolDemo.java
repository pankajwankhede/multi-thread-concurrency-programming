package com.xuliugen.demo.multithread.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        /*
         * 使用Executors框架生成ThreadPool
         */
        ExecutorService executorServiceByExecutors = Executors.newFixedThreadPool(4);

        /*
         * 自定义的ThreadPoolExecutor，但是使用的是默认的形式
         * int corePoolSize,
         * int maximumPoolSize,
         * long keepAliveTime,
         * TimeUnit unit,
         * BlockingQueue<Runnable> workQueue,
         * ThreadFactory threadFactory,
         * RejectedExecutionHandler handler
         */
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            int index = i;
            executorServiceByExecutors.submit(() -> System.out.println("i:" + index + " executorServiceByExecutors"));
            executorService.submit(() -> System.out.println("i:" + index + " executorService"));
        }
        executorService.shutdown();
    }
}
