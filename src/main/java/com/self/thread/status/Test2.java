package com.self.thread.status;
/**
 * 执行sleep()方法后线程的状态就是TIMED_WAITING
 * @author Administrator
 *
 */
public class Test2 {
	static class MyThread extends Thread{
		@Override
		public void run() {
			try {
				System.out.println("begin sleep");
				Thread.sleep(100000);
				System.out.println("end sleep");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		try {
			MyThread t  = new MyThread();
			t.start();
			Thread.sleep(1000);
			System.out.println("main 方法中的状态2：" + t.getState());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
