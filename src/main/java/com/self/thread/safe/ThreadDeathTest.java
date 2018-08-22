package com.self.thread.safe;

public class ThreadDeathTest extends Thread {
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			this.stop();
		} catch (ThreadDeath e) {
			System.out.println("进入catch()方法");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ThreadDeathTest thread = new ThreadDeathTest();
		thread.start();
	}
}
