package com.xuliugen.demo.multithread.pool;

import java.util.concurrent.*;

public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Runnable wrap(Runnable task, Exception clientTrace, String currentThreadName) {
        return () -> {
            try {
                task.run();
            } catch (Exception e) {
                clientTrace.printStackTrace();
                throw e;
            }
        };
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {
            int index = i;
            pool.execute(() -> divTask(100, index));
        }
    }

    private static void divTask(int a, int b) {
        double result = a / b;
        System.out.println(result);
    }
}
