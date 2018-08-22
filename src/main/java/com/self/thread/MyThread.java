package com.self.thread;

public class MyThread extends Thread {

	private int count = 5;
	@Override
	synchronized public void run() {
		super.run();
		count --;
		System.out.println("由 "+MyThread.currentThread().getName()+ " 计算,count ="+count);
	}
	
	public static void main(String[] args) {
		MyThread mythread = new MyThread();
		Thread a = new Thread(mythread,"A");
		Thread b = new Thread(mythread,"B");
		Thread c = new Thread(mythread,"C");
		Thread d = new Thread(mythread,"D");
		Thread e = new Thread(mythread,"E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}
