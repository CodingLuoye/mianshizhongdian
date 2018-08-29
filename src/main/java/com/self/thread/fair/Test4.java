package com.self.thread.fair;

import java.util.concurrent.locks.ReentrantLock;
/**
 * tryLock() 仅调用时锁定未被宁一个线程保持的情况下，才获得该锁定
 * @author Administrator
 *
 */
public class Test4 {
	public static void main(String[] args) throws InterruptedException {
		final ServiceE service = new ServiceE();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.serviceMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.setName("A");
		thread.start();
		Thread thread2 = new Thread(runnable);
		thread2.setName("B");
		thread2.start();
	}
}
class ServiceE{
	private ReentrantLock lock = new ReentrantLock();
	public void serviceMethod(){
		if(lock.tryLock()){
			System.out.println(Thread.currentThread().getName() + " 获得锁");
		}else{
			System.out.println(Thread.currentThread().getName() + " 未获得锁");
		}
	}
}
