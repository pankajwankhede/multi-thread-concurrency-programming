package com.xuliugen.demo.multithread.sync;

/**
 * Created by xuliugen on 2017/9/10.
 */
public class DirtyRead {

    private String username = "xuliugen";
    private String password = "123456";

    public synchronized void setValue(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;

        System.out.println("setValue()之后的结果：username=" + this.username + "; password=" + this.password);
    }

    public synchronized void getValue() {
        System.out.println("getValue()得到的结果：username=" + this.username + "; password=" + this.password);
    }

    public static void main(String[] args) throws InterruptedException {
        final DirtyRead dirtyRead = new DirtyRead();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                dirtyRead.setValue("xuliugen123", "654321");
            }
        });

        t1.start();
        Thread.sleep(1000);
        dirtyRead.getValue();
    }

}
