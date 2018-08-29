package com.self.thread.fair;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitUninterruptibly2 {
	public static void main(String[] args) {
		MyServiceNew service = new MyServiceNew();
		MyThreadA myThread = new MyThreadA(service);
		myThread.start();
		MyThreadB myThread2 = new MyThreadB(service);
		myThread2.start();
	}
}
class MyThreadA extends Thread{
	private MyServiceNew service;
	public MyThreadA(MyServiceNew service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.waitMethod();
	}
}
class MyThreadB extends Thread{
	private MyServiceNew service;
	public MyThreadB(MyServiceNew service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.notifyMethod();
	}
}
class MyServiceNew{
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public void waitMethod(){
		try {
			Calendar calendarRef = Calendar.getInstance();
			calendarRef.add(Calendar.SECOND, 10);
			lock.lock();
			System.out.println("wait begin timer = " +  System.currentTimeMillis());
			condition.awaitUntil(calendarRef.getTime());
			System.out.println("wait end timer = " +  System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void notifyMethod(){
		try {
			Calendar calendarRef = Calendar.getInstance();
			calendarRef.add(Calendar.SECOND, 10);
			lock.lock();
			System.out.println("notify begin timer = " +  System.currentTimeMillis());
			condition.signalAll();
			System.out.println("notify end timer = " +  System.currentTimeMillis());
		} finally {
			lock.unlock();
		}
	}
}