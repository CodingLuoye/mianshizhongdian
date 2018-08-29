package com.self.thread.fair;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * hasWaiters(Condition condition) 查询是否有现场正在等待与此锁定有关的condtion条件
 * 
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		final ServiceB service = new ServiceB();
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
class ServiceB{
	private ReentrantLock lock = new ReentrantLock();
	private Condition newCondtion = lock.newCondition();
	public void waitMethod(){
		try {
			lock.lock();
			newCondtion.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void notityMethod(){
		try {
			lock.lock();
			System.out.println("有没有线程正在等待newCondition?" + lock.hasWaiters(newCondtion) + " 线程数是多少？" +lock.getWaitQueueLength(newCondtion));
			newCondtion.signal();
		} finally {
			lock.unlock();
		}
	}
}
