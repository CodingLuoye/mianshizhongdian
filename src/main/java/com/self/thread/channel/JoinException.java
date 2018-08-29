package com.self.thread.channel;
class ThreadA extends Thread{
	@Override
	public void run() {
		for (int i = 0; i <Integer.MAX_VALUE; i++) {
			@SuppressWarnings("unused")
			String newString = new String();
			Math.random();
		}
	}
}

class ThreadB extends Thread{
	@Override
	public void run() {
		try {
			ThreadA a = new ThreadA();
			a.start();
			a.join();
			System.out.println("线程B在run end处打印了");
		} catch (Exception e) {
			System.out.println("线程B在catch处打印了");
			e.printStackTrace();
		}
	}
}

class ThreadC extends Thread{
	private ThreadB threadB;
	public ThreadC(ThreadB threadB) {
		super();
		this.threadB =threadB;
	}
	@Override
	public void run() {
		threadB.interrupt();
	}
}
public class JoinException {
	public static void main(String[] args) {
		try {
			ThreadB b = new ThreadB();
			b.start();
			Thread.sleep(500);
			ThreadC c = new ThreadC(b);
			c.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
