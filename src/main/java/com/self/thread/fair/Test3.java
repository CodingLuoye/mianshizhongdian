package com.self.thread.fair;

import java.util.concurrent.locks.ReentrantLock;
/**
 * isFair 判断是否是公平锁，默认使用的非公平锁
 * isHeldByCurrentThread() 判断当前线程是否保持此锁定
 * isLocked() 的作用是查询此锁定是否由任意线程保持
 * @author Administrator
 *
 */
public class Test3 {
	public static void main(String[] args) throws InterruptedException {
		final ServiceC service = new ServiceC(true);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.serviceMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		final ServiceC service2 = new ServiceC(false);
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				service2.serviceMethod();
			}
		};
		Thread thread2 = new Thread(runnable2);
		thread2.start();
	}
}
class ServiceC{
	private ReentrantLock lock;
	public ServiceC(boolean isFair){
		super();
		lock = new ReentrantLock(isFair);
	}
	public void serviceMethod(){
		try {
			System.out.println(" isHeldByCurrentThread  "+lock.isHeldByCurrentThread());
			System.out.println("isLocked   "+lock.isLocked());
			lock.lock();
			System.out.println(" isHeldByCurrentThread  "+lock.isHeldByCurrentThread());
			System.out.println("isLocked   "+lock.isLocked());
			System.out.println("公平锁情况 " +lock.isFair());
		} finally {
			lock.unlock();
		}
	}
}
