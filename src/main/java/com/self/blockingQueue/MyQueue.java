package com.self.blockingQueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue {
	private LinkedList<String> linkedList = new LinkedList<String>();
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private int max = 5;

	public String add(String str) throws InterruptedException {
		lock.lock();
		while (linkedList.size() == max) {
			condition.await();
		}
		linkedList.add(str);
		condition.signalAll();
		lock.unlock();
		return str;
	}

	public String removeFirst() throws InterruptedException {
		lock.lock();
		while (linkedList.size() == 0) {
			condition.await();
		}
		String removeFirst = linkedList.removeFirst();
		condition.signalAll();
		lock.unlock();
		return removeFirst;
	}

	public int getSize() {
		lock.lock();
		int size = linkedList.size();
		lock.unlock();
		return size;
	}

}