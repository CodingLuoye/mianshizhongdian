package com.self.thread.fair;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitUninterruptibly {
	public static void main(String[] args) {
		try {
			MyService service = new MyService();
			MyThread myThread = new MyThread(service);
			myThread.start();
			Thread.sleep(3000);
			myThread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class MyThread extends Thread{
	private MyService service;
	public MyThread(MyService service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.testMethod();
	}
}
class MyService{
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public void testMethod(){
		try {
			lock.lock();
			System.out.println("wait begin");
			condition.await();
			// condition.awaitUninterruptibly(); 不会抛出异常
			System.out.println("wait end");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("catch");
		} finally {
			lock.unlock();
		}
	}
}