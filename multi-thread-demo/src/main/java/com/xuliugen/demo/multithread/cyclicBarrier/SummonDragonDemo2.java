package com.xuliugen.demo.multithread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SummonDragonDemo2 {

    private static final int THREAD_COUNT_NUM = 7;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        //设置第一个屏障点，等待召集齐7位法师
        CyclicBarrier callMasterBarrier = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            boolean flag = false;

            @Override
            public void run() {
                System.out.println("到达障碍点！");
            }
        });

        //设置第二个屏障点，等待7位法师收集完7颗龙珠，召唤神龙
        CyclicBarrier summonDragonBarrier = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("集齐七颗龙珠！召唤神龙！");
            }
        });

        callMaster(callMasterBarrier); //召集齐7位法师
        callMasterBarrier.reset();
        collectDragonBall(callMasterBarrier);//收集龙珠
    }

    private static void callMaster(CyclicBarrier cyclicBarrier) {
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("召集了第" + index + "个法师");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void collectDragonBall(CyclicBarrier cyclicBarrier) {
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("第" + index + "颗龙珠已收集到！");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
