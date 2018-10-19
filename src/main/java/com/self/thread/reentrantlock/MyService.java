package com.self.thread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread{
	private MyService service;
	public MyThread(MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.testMethod();
	}
}
class ThreadA extends Thread{
	private MyService service;
	public ThreadA(MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.methodA();
	}
}
class ThreadAA extends Thread{
	private MyService service;
	public ThreadAA(MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.methodA();
	}
}
class ThreadB extends Thread{
	private MyService service;
	public ThreadB(MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.methodB();
	}
}
class ThreadBB extends Thread{
	private MyService service;
	public ThreadBB(MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.methodB();
	}
}
public class MyService {
	private Lock lock = new ReentrantLock();
	public void testMethod(){
		lock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("ThreadName = "+Thread.currentThread().getName() + (" " +(i+1)));
		}
		lock.unlock();
	}
	public void methodA(){
		try {
			lock.lock();
			System.out.println("methodA begin threadName" + Thread.currentThread().getName() + " timer="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("methodA end threadName" + Thread.currentThread().getName() + " timer="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void methodB(){
		try {
			lock.lock();
			System.out.println("methodB begin threadName" + Thread.currentThread().getName() + " timer="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("methodB end threadName" + Thread.currentThread().getName() + " timer="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		MyService service = new MyService();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadAA aa = new ThreadAA(service);
		aa.setName("AA");
		aa.start();
		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
		ThreadBB bb = new ThreadBB(service);
		bb.setName("BB");
		bb.start();
		
	}
}
