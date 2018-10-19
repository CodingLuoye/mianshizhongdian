package com.self.countdownlatch;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch 实现指定方法唤醒
 * CountDownLatch能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。
 * 使用一个计数器进行实现。计数器初始值为线程的数量。当每一个线程完成自己任务后，计数器的值就会减一。
 * 当计数器的值为0时，表示所有的线程都已经完成了任务，然后在CountDownLatch上等待的线程就可以恢复执行任务。
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
