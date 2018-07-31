package com.self.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 同时开始
 * @author Admin
 *
 */
public class RaceWithCountDownLatch {

	static class Racer extends Thread{
		CountDownLatch latch;
		public Racer(CountDownLatch latch){
			this.latch = latch;
		}
		@Override
		public void run() {
			try {
				this.latch.await();
				System.out.println(getName() + "start run "+System.currentTimeMillis());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int num = 10;
		CountDownLatch latch = new CountDownLatch(1);
		Thread[] racers = new Thread[num];
		for (int i = 0; i < num; i++) {
			racers[i] = new Racer(latch);
			racers[i].start();
		}
		Thread.sleep(1000);
		latch.countDown();
	}
}
