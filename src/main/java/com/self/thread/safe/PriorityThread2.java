package com.self.thread.safe;

import java.util.Random;

class MyThreadPriority3 extends Thread{
	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 50000; j++) {
				Random random = new Random();
				random.nextInt();
				addResult = addResult + i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("★ ★ ★ ★ ★ thread 1 use time = "+ (endTime - beginTime));
	}
}

class MyThreadPriority4 extends Thread{
	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 50000; j++) {
				Random random = new Random();
				random.nextInt();
				addResult = addResult + i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("☆  ☆ ☆ ☆ ☆ thread 2 use time = "+ (endTime - beginTime));
	}
}
public class PriorityThread2 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			MyThreadPriority3 thread1 = new MyThreadPriority3();
			thread1.setPriority(6);
			thread1.start();
			MyThreadPriority4 thread2 = new MyThreadPriority4();
			thread2.setPriority(5);
			thread2.start();
		}
	}
}
