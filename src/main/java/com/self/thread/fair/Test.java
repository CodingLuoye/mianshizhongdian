package com.self.thread.fair;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * hasQueuedThread(Thread thread) 查询指定的线程是否正在等待获取次锁定
 * 
 * hasQueuedThreads() 查询是否有现场正在获取此锁定
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		final ServiceA service = new ServiceA();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.waitMethod();
			}
		};
		Thread threadA  = new Thread(runnable);
		threadA.start();
		Thread.sleep(5000);
		Thread threadB  = new Thread(runnable);
		threadB.start();
		Thread.sleep(5000);
		System.out.println(service.lock.hasQueuedThread(threadA));
		System.out.println(service.lock.hasQueuedThread(threadB));
		System.out.println(service.lock.hasQueuedThreads());
	}
}
class ServiceA{
	public ReentrantLock lock = new ReentrantLock();
	public Condition newCondtion = lock.newCondition();
	public void waitMethod(){
		try {
			lock.lock();
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
