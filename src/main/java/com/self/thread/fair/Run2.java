package com.self.thread.fair;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * getWaitQueueLengh 作用是返回等待与此锁定相关的给定条件Condition的线程估计数
 * @author Administrator
 *
 */
public class Run2 {
	public static void main(String[] args) throws InterruptedException {
		final Service4 service = new Service4();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.waitMethod();
			}
		};
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(runnable);
			threadArray[i].start();
		}
		Thread.sleep(2000);
		service.notityMethod();
	}
}
class Service4 {
	private ReentrantLock lock = new ReentrantLock();
	private Condition newCondition = lock.newCondition();
	public void waitMethod(){
		try {
			lock.lock();
			newCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void notityMethod(){
		try {
			lock.lock();
			System.out.println("有" + lock.getWaitQueueLength(newCondition) + "个现线程在等待newcondition");
			newCondition.signal();
		} finally {
			lock.unlock();
		}
	}
}