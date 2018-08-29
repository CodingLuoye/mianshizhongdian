package com.self.thread.fair;

import java.util.concurrent.locks.ReentrantLock;
/**
 * getHoldCount的作用是查询当前线程保持此锁定的个数
 * @author Administrator
 *
 */
public class Service2 {
	private ReentrantLock lock = new ReentrantLock();
	public void serviceMethod1(){
		try {
			lock.lock();
			System.out.println("serviceMethod1 getHoldCount = " +lock.getHoldCount());
			serviceMethod2();
		} finally {
			lock.unlock();
		}
	}
	public void serviceMethod2(){
		try {
			lock.lock();
			System.out.println("serviceMethod2 getHoldCount = " +lock.getHoldCount());
		} finally {
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		Service2 service = new Service2();
		service.serviceMethod1();
	}
}
