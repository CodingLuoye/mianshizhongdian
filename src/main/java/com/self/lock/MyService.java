package com.self.lock;

public class MyService {
	private String lock = "123";
	public void testMethod(){
		try {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
				lock = "456";
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
