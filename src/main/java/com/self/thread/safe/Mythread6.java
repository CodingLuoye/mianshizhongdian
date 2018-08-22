package com.self.thread.safe;

/**
 * 验证线程先interrupt()再sleep
 * @author Administrator
 *
 */
public class Mythread6 extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 100000; i++) {
				System.out.println("i="+(i+1));
			}
			System.out.println("run begin");
			Thread.sleep(200000);
			System.out.println("run end ");
		} catch (InterruptedException e) {
			System.out.println("先停止,再遇到了sleep!进去catch"+this.isInterrupted());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Mythread6 thread = new Mythread6();
			thread.start();
			thread.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
