package com.self.thread;

public class HelloThread extends Thread {
	@Override
	public void run() {
		System.out.println("Thread name:" +Thread.currentThread().getName());
		System.out.println("hello ");
	}
	
	public static void main(String[] args) {
		Thread thread = new HelloThread();
		thread.start(); //Thread name:Thread-0  hello  说明调用star方法启动了两条线程
//		thread.run();  //Thread name:main hello 
		
		Thread thread2 = new Thread(new HelloRunable());
		thread2.start();
	}
}
class HelloRunable implements Runnable{

	@Override
	public void run() {
		System.out.println("hello Runnable");
	}
}
