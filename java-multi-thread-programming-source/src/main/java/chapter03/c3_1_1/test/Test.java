package chapter03.c3_1_1.test;


import chapter03.c3_1_1.extthread.ThreadA;
import chapter03.c3_1_1.extthread.ThreadB;
import chapter03.c3_1_1.mylist.MyList;

public class Test {

    public static void main(String[] args) {
        MyList service = new MyList();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
