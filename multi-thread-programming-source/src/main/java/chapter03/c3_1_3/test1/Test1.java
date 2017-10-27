package chapter03.c3_1_3.test1;

public class Test1 {
    public static void main(String[] args) {
        try {
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//Exception in thread "main" java.lang.IllegalMonitorStateException
//    at java.lang.Object.wait(Native Method)
//    at java.lang.Object.wait(Object.java:502)
//    at chapter03.c3_1_3.test1.Test1.main(Test1.java:7)
