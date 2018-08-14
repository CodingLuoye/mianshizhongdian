package com.self.countdownlatch;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch 实现指定方法唤醒
 * @author Administrator
 *
 */
public class MyClass {
	CountDownLatch countdownLatch = new CountDownLatch(2);

	public void method1() throws InterruptedException {
		System.out.println("Enter method1");
		countdownLatch.await();
		System.out.println("method1 has been woken up");
	}

	public void method2() {
		System.out.println("method2 about to wake method1 up");
		countdownLatch.countDown();
	}

	public void method3() {
		System.out.println("method3 about to wake method1 up");
		countdownLatch.countDown();
	}
}
