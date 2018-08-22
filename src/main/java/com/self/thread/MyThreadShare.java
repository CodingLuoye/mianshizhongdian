package com.self.thread;

/**
 * Thread share data
 * @author Administrator
 *
 */
public class MyThreadShare extends Thread {

	private int count = 5;
	@Override
	public void run() {
		super.run();
		count --;
		System.out.println("由 "+ MyThreadShare.currentThread().getName() + " 计算,count="+count);
	}
	public static void main(String[] args) {
		MyThreadShare mythread = new MyThreadShare();
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
