package com.xuliugen.demo.multithread.singleton;

/**
 * Created by xuliugen on 2017/10/22.
 */
public class Sintelon {

    private static Sintelon instance = new Sintelon();

    public static String VARIABLE = "hello world!";

    private Sintelon() {
        System.out.println("Singtelon is created!");
    }

    public static Sintelon getInstance() {
        return instance;
    }


    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Sintelon.getInstance();
//        }

        for (int i = 0; i < 3; i++) {
            System.out.println(Sintelon.VARIABLE);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(Sintelon.VARIABLE);
        }
    }
}
