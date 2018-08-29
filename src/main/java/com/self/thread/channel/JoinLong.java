package com.self.thread.channel;

class MyThread2 extends Thread{
	@Override
	public void run() {
		try {
			System.out.println("begin Timer = " + System.currentTimeMillis());
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
public class JoinLong {
	public static void main(String[] args) {
		try {
			MyThread2 threadTest = new MyThread2();
			threadTest.start();
			threadTest.join(2000);
			//Thread.sleep(2000);
			System.out.println(" end timer= "+ System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //只等2秒
	}
}
