package com.self.thread;

/**
 * 内存可见性 缓存 demo,使用volatile   一个线程对内存的修改,另一个线程看不到
 * @author JackChen
 *
 */
public class VisibilityDemo {
	private static volatile boolean shutdown = false;
	static class HelloThread extends Thread{
		@Override
		public void run() {
			while(!shutdown){
				
			}
			System.out.println("exit hello ");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		new HelloThread().start();
		Thread.sleep(1000);
		shutdown = true;
		System.out.println("exit main");
	}

}
