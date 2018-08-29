package com.self.waitAndNotify;

public class MyThread1 extends Thread {
	private Object lock;
	public MyThread1(Object lock) {
		super();
		this.lock = lock;
	}
	@Override
	public void run() {
		try {
			synchronized (lock) {
				System.out.println("开始   wati time = "+ System.currentTimeMillis());
				lock.wait();
				System.out.println("结束   wati time = "+ System.currentTimeMillis());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
