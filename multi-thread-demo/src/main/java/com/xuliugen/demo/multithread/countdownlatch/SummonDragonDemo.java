package com.xuliugen.demo.multithread.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class SummonDragonDemo {

    private static final int THREAD_COUNT_NUM = 7;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    //模拟收集第i个龙珠
                    Thread.sleep(Math.abs(new Random().nextInt(3000)));
                    System.out.println("第" + index + "颗龙珠已收集到！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //每收集到一颗龙珠,需要等待的颗数减1
                countDownLatch.countDown();
            }).start();
        }
        //等待检查，即上述7个线程执行完毕之后，执行await后边的代码
        countDownLatch.await();
        System.out.println("集齐七颗龙珠！召唤神龙！");
    }
}
