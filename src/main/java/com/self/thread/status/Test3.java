package com.self.thread.status;
/**
 * BLOCKED 状态出现在某一个线程在等待锁的时候
 * @author Administrator
 *
 */
public class Test3 {
	static class MyService{
		synchronized static public void serviceMethod(){
			try {
				System.out.println(Thread.currentThread().getName() + "进入了业务方法");
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static class MyThread1 extends Thread{
		@Override
		public void run() {
			MyService.serviceMethod();
		}
	}
	static class MyThread2 extends Thread{
		@Override
		public void run() {
			MyService.serviceMethod();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		MyThread1 t1  = new MyThread1();
		t1.setName("A");
		t1.start();
		MyThread2 t2  = new MyThread2();
		t2.setName("B");
		t2.start();
		Thread.sleep(1000);
		System.out.println("main 方法中的状态2：" + t2.getState());
	}
}
