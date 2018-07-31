package com.self.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	static class Tourist extends Thread{
		CyclicBarrier barrier;
		public Tourist(CyclicBarrier barrier){
			this.barrier = barrier;
		}
		@Override
		public void run() {
			try {
				Thread.sleep((int)(Math.random()*1000));
				barrier.await();
				System.out.println(this.getName() + "arrived A" + System.currentTimeMillis());
				//集合后模拟在各自独立运行
				Thread.sleep((int)(Math.random()*1000));
				barrier.await();
				System.out.println(this.getName() + "arrived B" + System.currentTimeMillis());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		int num = 3;
		Tourist[] threads = new Tourist[num];
		CyclicBarrier barrier = new CyclicBarrier(num,new Runnable() {
			@Override
			public void run() {
				System.out.println("all arrived "+System.currentTimeMillis() + "executed by " +Thread.currentThread().getName());
			}
		});
		for (int i = 0; i < num; i++) {
			threads[i] = new Tourist(barrier);
			threads[i].start();
		}
	}
}
