package com.self.thread;

public class InterruptSynchronizedDemo {
	private static Object lock = new Object();
	private static class A extends Thread{
		@Override
		public void run() {
			synchronized (lock) {
				while(!Thread.currentThread().isInterrupted()){
					
				}
			}
			System.out.println("exit");
		}
	}
	public static void test() throws InterruptedException{
		synchronized (lock) {
			A a = new A();
			a.start();
			Thread.sleep(100);
			a.interrupt();
			a.join();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
