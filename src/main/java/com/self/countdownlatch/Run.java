package com.self.countdownlatch;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		final MyClass myClass = new MyClass();

		new Thread(new Runnable() {
			public void run() {
				try {
					myClass.method1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		Thread.sleep(2000);
		
		new Thread(new Runnable() {
			public void run() {
				myClass.method2();
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				myClass.method3();
			}
		}).start();

	}
}
