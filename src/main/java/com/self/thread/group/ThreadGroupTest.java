package com.self.thread.group;

public class ThreadGroupTest {
	static class ThreadA extends Thread{
		@Override
		public void run() {
			try {
				while(!Thread.currentThread().isInterrupted()){
					System.out.println("ThreadName = " + Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static class ThreadB extends Thread{
		@Override
		public void run() {
			try {
				while(!Thread.currentThread().isInterrupted()){
					System.out.println("ThreadName = " + Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ThreadA aRunnable = new ThreadA();
		ThreadB bRunnable = new ThreadB();
		ThreadGroup group = new ThreadGroup("高研所的线程组");
		Thread aThread = new Thread(group,aRunnable);
		Thread bThread = new Thread(group,bRunnable);
		aThread.start();
		bThread.start();
		System.out.println("活动的线程数为：" + group.activeCount());
		System.out.println("线程组的名称为：" + group.getName());
	}
}
