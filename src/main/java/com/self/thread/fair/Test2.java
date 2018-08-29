package com.self.thread.fair;

import java.util.concurrent.locks.ReentrantLock;
/**
 * lockInterruptibly 如果当前线程未被中断，则获取锁定，如果已被中断，则抛出异常
 * @author Administrator
 *
 */
public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		final ServiceD service = new ServiceD();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.waitMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.setName("A");
		thread.start();
		Thread.sleep(500);
		Thread thread2 = new Thread(runnable);
		thread2.setName("B");
		thread2.start();
		thread2.interrupt(); //打标记
		System.out.println("main end");
	}
}
class ServiceD{
	public ReentrantLock lock = new ReentrantLock();
	public void waitMethod(){
		try {
			lock.lockInterruptibly();
			System.out.println("lock begin " + Thread.currentThread().getName());
			for (int i = 0; i < Integer.MAX_VALUE /10; i++) {
				Math.random();
			}
			System.out.println("lock end" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
	}
}
