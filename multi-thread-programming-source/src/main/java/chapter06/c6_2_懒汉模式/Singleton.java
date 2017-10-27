package chapter06.c6_2_懒汉模式;

public class Singleton {

    private static Singleton myObject;

    private Singleton() {
    }

    public static Singleton getInstance() {
        //延迟加载
        if (myObject != null) {
        } else {
            myObject = new Singleton();
        }
        return myObject;
    }
}
