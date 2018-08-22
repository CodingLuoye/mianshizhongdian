package com.self.thread.safe;

/**
 * 验证线程在sleep()状态下停止
 * @author Administrator
 *
 */
public class Mythread5 extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("run begin");
			Thread.sleep(200000);
			System.out.println("run end ");
		} catch (InterruptedException e) {
			System.out.println("在沉睡中被停止！进入catch!"+this.isInterrupted());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Mythread5 thread = new Mythread5();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
