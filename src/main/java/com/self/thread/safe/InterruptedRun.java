package com.self.thread.safe;

class Mythread extends Thread{
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i="+(i-1));
		}
	}
}

public class InterruptedRun {
	public static void main(String[] args) {
		try {
			Mythread thread = new Mythread();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt();
			//Thread.currentThread().interrupt();
			System.out.println("是否停止1？="+thread.isInterrupted());
			System.out.println("是否停止2？="+thread.isInterrupted());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
