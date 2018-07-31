package com.self.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	private final Lock lock = new ReentrantLock();
	private volatile int count;
	public void incr(){
		lock.lock();
		try {
			count ++;
		} catch (Exception e) {
			lock.unlock();
		}
	}
	public int getCount(){
		return count;
	}

}
