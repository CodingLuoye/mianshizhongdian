package com.self.thread.joinSleep;
class ThreadSleep extends Thread{
	private ThreadB b;
	public ThreadSleep(ThreadB b) {
		super();
		this.b = b;
	}
	@Override
	public void run() {
		try {
			synchronized (b) {
				b.start();
				b.join();
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					@SuppressWarnings("unused")
					String newString = new  String();
					Math.random();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/**
 * join方法会释放锁
 * @author Administrator
 *
 */
public class SleepRun {
	public static void main(String[] args) {
		try {
			ThreadB b = new ThreadB();
			ThreadSleep a = new ThreadSleep(b);
			a.start();
			Thread.sleep(1000);
			ThreadC c = new ThreadC(b);
			c.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
