package com.xuliugen.demo.multithread.synchronized_test;

public class DemoRun {

    public static void main(String[] args) {
        MyList myList = new MyList();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                myList.setList(i + "");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println("*************size:" + myList.getListSize());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                myList.setList2(i + "");
            }
        }).start();


    }
}
