package com.xuliugen.demo.multithread.treadlocal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalOOMDemo {

    private static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    private static final int THREAD_LOOP_SIZE = 2000;
    private static final int MOCK_DIB_DATA_LOOP_SIZE = 100000;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            int index = i;
            executorService.execute(() -> {
                threadLocal.set(addBigList());
                if (index == THREAD_LOOP_SIZE - 2) {
                    Thread t = Thread.currentThread();
                    threadLocal.get().forEach(param -> System.out.println(Thread.currentThread().getName() + " " + param));
                }
            });
        }
    }

    private static List<String> addBigList() {
        List<String> params = new ArrayList<>(MOCK_DIB_DATA_LOOP_SIZE);
        for (int i = 0; i < MOCK_DIB_DATA_LOOP_SIZE; i++) {
            params.add("张三:上班这么多年 这些福利你知道吗？Index:" + i);
        }
        return params;
    }
}
