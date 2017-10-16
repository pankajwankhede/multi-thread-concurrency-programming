package com.xuliugen.demo.multithread.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo2 {

    public static void main(String[] args) {
        /*
         * int corePoolSize,
         * int maximumPoolSize,
         * long keepAliveTime,
         * TimeUnit unit,
         * BlockingQueue<Runnable> workQueue,
         * ThreadFactory threadFactory,
         * RejectedExecutionHandler handler
         */
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), r -> {
            Thread thread = new Thread(r);
            thread.setName(r.getClass().getName());
            return thread;
        }, new ThreadPoolExecutor.AbortPolicy()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                System.out.println("beforeExecute");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("afterExecute");
            }

            @Override
            protected void terminated() {
                super.terminated();
                System.out.println("terminated");
            }
        };

        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> System.out.println("i:" + index));
        }

        executorService.shutdown();
    }
}
