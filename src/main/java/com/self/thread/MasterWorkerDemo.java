package com.self.thread;

import java.util.concurrent.CountDownLatch;

public class MasterWorkerDemo {
	static class Worker extends Thread{
		CountDownLatch latch;
		public Worker(CountDownLatch latch){
			this.latch = latch;
		}
		@Override
		public void run() {
			try {
				Thread.sleep((int)(Math.random() * 1000));
				if(Math.random() < 0.02){
					throw new RuntimeException("bad luck"); 
				}
			} catch (InterruptedException e) {
				//System.out.println(e.getMessage());
			}finally{
				this.latch.countDown();
			}
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int workerNum = 100;
		CountDownLatch latch = new CountDownLatch(workerNum);
		Worker[] workers = new Worker[workerNum];
		for (int i = 0; i < workerNum; i++) {
			workers[i] = new Worker(latch);
			workers[i].start();
		}
		latch.await();
		System.out.println("collect worker result");
	}


}
