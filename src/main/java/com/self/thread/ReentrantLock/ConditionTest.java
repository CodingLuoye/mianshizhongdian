package com.self.thread.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class MyServiceA{
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;
	public void set(){
		try {
			lock.lock();
			while(hasValue == true){
				System.out.println("有可能===========连续");
				condition.await();
			}
			System.out.println("打印 ====");
			hasValue = true;
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void get(){
		try {
			lock.lock();
			while(hasValue == false){
				System.out.println("有可能----------------连续");
				condition.await();
			}
			System.out.println("打印 ----");
			hasValue = false;
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}
class MyThreadQ extends Thread{
	private MyServiceA myservice;
	public MyThreadQ(MyServiceA myservice) {
		super();
		this.myservice = myservice;
	}
	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			myservice.set();
		}
	}
}
class MyThreadW extends Thread{
	private MyServiceA myservice;
	public MyThreadW(MyServiceA myservice) {
		super();
		this.myservice = myservice;
	}
	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			myservice.get();
		}
	}
}
public class ConditionTest {
	public static void main(String[] args) {
		MyServiceA myService = new MyServiceA();
//		MyThreadQ a = new MyThreadQ(myService);
//		a.start();
//		MyThreadW b = new MyThreadW(myService);
//		b.start();
		MyThreadQ[] threadA = new MyThreadQ[10];
		MyThreadW[] threadB = new MyThreadW[10];
		for (int i = 0; i < 10; i++) {
			threadA[i] = new MyThreadQ(myService);
			threadB[i] = new MyThreadW(myService);
			threadA[i].start();
			threadB[i].start();
		}
		
	}
}
