package com.self.thread.fair;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 * tryLock() 仅调用时锁定未被宁一个线程保持的情况下，才获得该锁定
 * @author Administrator
 *
 */
public class Test5 {
	public static void main(String[] args) throws InterruptedException {
		final ServiceF service = new ServiceF();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " 调用waitMethod时间：" +System.currentTimeMillis());
				service.waitMethod();
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
class ServiceF{
	private ReentrantLock lock = new ReentrantLock();
	public void waitMethod(){
		try {
			if(lock.tryLock(3,TimeUnit.SECONDS)){
				System.out.println(Thread.currentThread().getName() + " 获得锁的时间： "+System.currentTimeMillis());
				Thread.sleep(10000);
			}else{
				System.out.println(Thread.currentThread().getName() + " 没有获得锁");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
	}
}
