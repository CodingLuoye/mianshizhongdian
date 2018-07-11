package com.self.thread;

public class WaitThread extends Thread {
	
	private volatile boolean fire = false;
	
	@Override
	public void run(){
		try {
			synchronized (this) {
				while(!fire){
					wait();
				}
			}
			System.out.println("fired");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void fired(){
		this.fire = true;
		notify();
	}
	
	public static void main(String[] args) throws Exception {
		WaitThread waitThread = new WaitThread();
		waitThread.start();
		Thread.sleep(1000);
		System.out.println("fire");
		waitThread.fired();
	}

}
