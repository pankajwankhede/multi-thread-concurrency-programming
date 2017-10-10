package character02.c2_3_1;

public class MyThread {

    private boolean isRunning = true;

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void printThreadName() {
        while (isRunning) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final MyThread myThread = new MyThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.printThreadName();
            }
        }).start();
        Thread.sleep(3000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("设置isRunning为false");
                myThread.setRunning(false);
            }
        }).start();
    }
}