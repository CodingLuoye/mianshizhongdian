package com.self.thread.fair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * getQueueLength()返回正等待获取此锁定的现场估计数
 * @author Administrator
 *
 */
public class Run {
	public static void main(String[] args) throws InterruptedException {
		final Service3 service = new Service3();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.serviceMethod1();
			}
		};
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(runnable);
			threadArray[i].start();
		}
		Thread.sleep(2000);
		System.out.println("有线程数：" +service.lock.getQueueLength() + "在等待获取锁");
	}
}
class Service3 {
	public ReentrantLock lock = new ReentrantLock();
	public void serviceMethod1(){
		try {
			lock.lock();
			System.out.println("ThreadName = " +Thread.currentThread().getName());
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
