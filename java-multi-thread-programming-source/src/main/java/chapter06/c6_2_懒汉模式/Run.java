package chapter06.c6_2_懒汉模式;

import java.util.HashSet;
import java.util.Set;

public class Run {

//    public static void main(String[] args) {
//        Set<Integer> hashCode = new HashSet<>(1000);
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 10000; j++) {
//                    hashCode.add(Singleton.getInstance().hashCode());
//                }
//            }).start();
//        }
//        System.out.println(hashCode.size());
//    }

    public static void main(String[] args) throws InterruptedException {
        Set<Integer> hashCode = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                int code = Singleton.getInstance().hashCode();
                hashCode.add(code);
            }).start();
        }
        System.out.println(hashCode.size());
    }
}
