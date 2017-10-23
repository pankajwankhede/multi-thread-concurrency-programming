package com.xuliugen.demo.multithread.singleton;

/**
 * Created by xuliugen on 2017/10/22.
 */
public class LazySintelon {

    private static LazySintelon instance;

    public static String VARIABLE = "hello world!";

    private LazySintelon() {
        System.out.println("LazySintelon is created!");
    }

    public synchronized LazySintelon getInstance() {
        if (instance == null) {
            instance = new LazySintelon();
        }
        return instance;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Sintelon.getInstance();
//        }

        for (int i = 0; i < 3; i++) {
            System.out.println(LazySintelon.VARIABLE);
        }
    }
}
