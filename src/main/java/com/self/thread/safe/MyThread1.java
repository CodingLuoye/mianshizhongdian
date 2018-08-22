package com.self.thread.safe;

public class MyThread1 extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("run this.getName()= "+this.getName());
			System.out.println("run threadName = " +MyThread1.currentThread().getName() + " begin");
			Thread.sleep(2000);
			System.out.println("run threadName = " +MyThread1.currentThread().getName() + " end");
			System.out.println("run this.getName()= "+this.getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		MyThread1 mythread = new MyThread1();
		System.out.println("begin = " +System.currentTimeMillis());
		mythread.run();
		System.out.println("end = " +System.currentTimeMillis());
	}
}
