package com.xuliugen.demo.multithread.shejimoshi;

public class DubbleSingleton {

	private static DubbleSingleton instance;
	
	public static DubbleSingleton getInstance(){
		if(instance == null){
			try {
				//模拟初始化对象的准备时间...
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (DubbleSingleton.class) {
				if(instance == null){
					instance = new DubbleSingleton();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getInstance().hashCode());
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getInstance().hashCode());
			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getInstance().hashCode());
			}
		},"t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}
