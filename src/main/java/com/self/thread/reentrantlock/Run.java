package com.self.thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		MyService1 service = new MyService1();
		Thread1 a = new Thread1(service);
		a.start();
		Thread.sleep(3000);
		service.singal();
	}
}
class Thread1 extends Thread{
	private MyService1 service;
	public Thread1(MyService1 service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.waitMethod();
	}
}
class MyService1{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public void waitMethod(){
		try {
			lock.lock();
			System.out.println("A");
			condition.await();
			System.out.println("B");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println("锁释放了");
		}
	}
	public void singal(){
		try {
			lock.lock();
			System.out.println("singal时间为：" + System.currentTimeMillis());
			condition.signal();
		}finally{
			lock.unlock();
		}
	}
}
