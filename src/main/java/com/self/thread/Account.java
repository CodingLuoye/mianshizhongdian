package com.self.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private Lock lock = new ReentrantLock();
	private volatile double money;
	public Account(double initialMoney){
		this.money = initialMoney;
	}
	public void add(double money){
		lock.lock();
		try {
			this.money += money;
		}finally{
			lock.unlock();
		}
	}
	public void reduce(double money){
		lock.lock();
		try {
			this.money -= money;
		} finally {
			lock.unlock();
		}
	}
	public double getMoney(){
		return money;
	}
	void lock(){
		lock.lock();
	}
	void unlock(){
		lock.unlock();
	}
	boolean tryLock(){
		return lock.tryLock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(){
			@Override
			public void run(){
				LockSupport.park();  //放弃cpu
				System.out.println("exit");
			}
		};
		t.start();
		Thread.sleep(100);
		LockSupport.unpark(t);
	}
}
