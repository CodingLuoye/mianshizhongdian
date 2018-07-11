package com.self.providerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintService {
	private ReentrantLock lock = new ReentrantLock();
	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();
	private Condition conditionC = lock.newCondition();
	
	volatile int nextPrint = 1;
	
	public void printA() throws InterruptedException {
		lock.lock();
		while(nextPrint != 1) {
			conditionA.await();
		}
		System.out.println("A");
		nextPrint=2;
		conditionB.signalAll();
		lock.unlock();
	}
	public void printB() throws InterruptedException {
		lock.lock();
		while(nextPrint != 2) {
			conditionB.await();
		}
		System.out.println("B");
		nextPrint=3;
		conditionC.signalAll();
		lock.unlock();
	}
	public void printC() throws InterruptedException {
		lock.lock();
		while(nextPrint != 3) {
			conditionC.await();
		}
		System.out.println("C");
		nextPrint=1;
		conditionA.signalAll();
		lock.unlock();
	}
	
}
