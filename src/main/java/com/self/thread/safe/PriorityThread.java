package com.self.thread.safe;

class MyThreadPriority1 extends Thread{
	@Override
	public void run() {
		System.out.println("MyThread1 run priority=" +this.getPriority());
		MyThreadPriority2 thread2 = new MyThreadPriority2();
		thread2.start();
	}
}

class MyThreadPriority2 extends Thread{
	@Override
	public void run() {
		System.out.println("MyThread2 run priority" + this.getPriority());
	}
}
public class PriorityThread {
	public static void main(String[] args) {
		System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main thread end priority=" + Thread.currentThread().getPriority());
		MyThreadPriority1 thread1 = new MyThreadPriority1();
		thread1.start();
	}
}
