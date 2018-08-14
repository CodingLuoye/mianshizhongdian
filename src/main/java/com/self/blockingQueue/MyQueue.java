package com.self.blockingQueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ReentrantLock操作是先调用lock(),操作完成后调用unlock()
 * Condition ReentrantLock.newCondition() 调用await(),调用singalAll()唤醒
 * @author Administrator
 *
 */
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