package chapter04.c4_1.c4_1_2.extthread;

import chapter04.c4_1.c4_1_2.service.MyService;

public class ThreadBB extends Thread {

	private MyService service;

	public ThreadBB(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}
}
