package com.self.thread.safe;

class MyThreadA extends Thread{
	private int count = 0;
	
	public int getCount(){
		return count;
	}
	@Override
	public void run() {
		while(true){
			count++;
		}
	}
}

class MyThreadB extends Thread{
	private int count = 0;
	public int getCount(){
		return count;
	}
	@Override
	public void run() {
		while(true){
			count++;
		}
	}
}
public class PriorityThread3 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			MyThreadA thread1 = new MyThreadA();
			thread1.setPriority(Thread.NORM_PRIORITY -3);
			thread1.start();
			MyThreadB thread2 = new MyThreadB();
			thread2.setPriority(Thread.NORM_PRIORITY +3);
			thread2.start();
			Thread.sleep(20000);
			thread1.stop();
			thread2.stop();
			System.out.println("a=" +thread1.getCount());
			System.out.println("b=" +thread2.getCount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
