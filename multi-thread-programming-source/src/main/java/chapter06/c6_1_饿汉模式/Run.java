package chapter06.c6_1_饿汉模式;

import java.util.HashSet;
import java.util.Set;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        Set<Integer> hashCode = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                int code = Singleton.getInstance().hashCode();
                hashCode.add(code);
            }).start();
        }
        System.out.println(hashCode.size());
    }
}
