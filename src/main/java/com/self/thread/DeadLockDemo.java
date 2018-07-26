package com.self.thread;

/**
 * 死锁demo
 * @author JackChen
 * 使用synchronized 所有的方法变成原子操作,但是复合操作，如先检查再更新 伪同步 迭代
 */
public class DeadLockDemo {
	private static Object lockA = new Object();
	private static Object lockB = new Object();
	private static void startThreadA(){
		Thread aThread = new Thread(){
			@Override
			public void run() {
				synchronized(lockA){
					try {
						Thread.sleep(1000);;
					} catch (Exception e) {
						// TODO: handle exception
					}
					synchronized (lockB) {
						
					}
				}
			}
		};
		aThread.start();
	}
	private static void startThreadB(){
		Thread bThread = new Thread(){
			@Override
			public void run() {
				synchronized(lockB){
					try {
						Thread.sleep(1000);;
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				synchronized (lockA) {
					
				}
			}
		};
		bThread.start();
	}
	public static void main(String[] args) {
		startThreadA();
		startThreadB();
	}

}
