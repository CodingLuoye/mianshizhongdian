package com.self.thread.status;
/**
 * 构造方法打印的是main主线程的状态为RUNNABLE
 * @author Administrator
 *
 */
public class Test {
	static class MyThread extends Thread{
		public MyThread(){
			System.out.println("构造方法中的状态" + Thread.currentThread().getState());
		}
		@Override
		public void run() {
			System.out.println("run方法中的状态" + Thread.currentThread().getState());
		}
	}
	public static void main(String[] args) {
		try {
			MyThread t  = new MyThread();
			System.out.println("main 方法中的状态1：" + t.getState());
			Thread.sleep(1000);
			t.start();
			Thread.sleep(1000);
			System.out.println("main 方法中的状态2：" + t.getState());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
