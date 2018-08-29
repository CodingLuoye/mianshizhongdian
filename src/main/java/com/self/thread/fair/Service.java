package com.self.thread.fair;

import java.util.concurrent.locks.ReentrantLock;
/**
 * 公平锁先启动的线程优先执行，不公平锁顺序不确定
 * @author Administrator
 *
 */
public class Service {
	private ReentrantLock lock;
	public Service(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}
	public void serviceMethod(){
		try {
			lock.lock();
			System.out.println("ThreadName===" + Thread.currentThread().getName() + "获得锁定");
		} finally {
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		final Service service = new Service(false);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("=线程" + Thread.currentThread().getName() +"运行了");
				service.serviceMethod();
			}
		};
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(runnable);
			threadArray[i].start();
		}
	}
}
