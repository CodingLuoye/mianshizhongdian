package com.self.thread.joinSleep;

class ThreadA extends Thread{
	private ThreadB b;
	public ThreadA(ThreadB b) {
		super();
		this.b = b;
	}
	@Override
	public void run() {
		try {
			synchronized (b) {
				b.start();
				Thread.sleep(6000);
				//Thread.sleep(); 不释放锁
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class ThreadB extends Thread{
	@Override
	public void run() {
		try {
			System.out.println("  b  run begin timer= " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("  b run end timer=" +System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	synchronized public void bService(){
		System.out.println("打印了bService timer=" + System.currentTimeMillis());
	}
}

class ThreadC extends Thread{
	private ThreadB threadB;
	public ThreadC(ThreadB threadB){
		super();
		this.threadB = threadB;
	}
	@Override
	public void run() {
		threadB.bService();
	}
}
public class Run {
	public static void main(String[] args) {
		try {
			ThreadB b = new ThreadB();
			ThreadA a = new ThreadA(b);
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
