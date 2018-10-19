package com.self.thread.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * lock.readLock 允许多个线程同时执行lock方法
 * lock.writeLock 同一时间只允许一个线程执行lock方法的代码
 * 读写、写读、写写 都是互斥的，只有读读是异步的，非互斥的
 * 
 * @author Administrator
 *
 */
public class ReadreadShare {
	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
//		ThreadA a = new ThreadA(service);
//		a.setName("A");
//		ThreadB b = new ThreadB(service);
//		b.setName("B");
//		a.start();
//		b.start();
//		ThreadC c = new ThreadC(service);
//		c.setName("C");
//		ThreadD d = new ThreadD(service);
//		d.setName("D");
//		c.start();
//		d.start();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();
		Thread.sleep(1000);
		ThreadB b = new ThreadB(service);
		b.setName("C");
		b.start();
		
	}
}
class Service{
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	public void read(){
		try {
			lock.readLock().lock();
			System.out.println("  获得该锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
	public void write(){
		try {
			lock.writeLock().lock();
			System.out.println("  获得写锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}
}
class ThreadA extends Thread{
	private Service service;
	public ThreadA(Service service) {
		this.service = service;
	}
	@Override
	public void run() {
		service.read();
	}
}
class ThreadB extends Thread{
	private Service service;
	public ThreadB(Service service) {
		this.service = service;
	}
	@Override
	public void run() {
		service.read();
	}
}
class ThreadC extends Thread{
	private Service service;
	public ThreadC(Service service) {
		this.service = service;
	}
	@Override
	public void run() {
		service.write();
	}
}
class ThreadD extends Thread{
	private Service service;
	public ThreadD(Service service) {
		this.service = service;
	}
	@Override
	public void run() {
		service.write();
	}
}