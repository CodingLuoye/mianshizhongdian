package com.self.thread.safe;

/**
 * 使用suspend暂定线程，resume恢复线程
 * @author Administrator
 *
 */
public class Mythread7 extends Thread {
	private long i = 0;
	public long getI(){
		return i;
	}
	public void setI(long i){
		this.i = i;
	}
	@Override
	public void run() {
		while(true){
			i++;
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Mythread7 thread = new Mythread7();
			thread.start();
			Thread.sleep(5000);
			//A 段
			thread.suspend();
			System.out.println("A=" + System.currentTimeMillis() + " i = "+ thread.getI());
			Thread.sleep(5000);
			System.out.println("A=" + System.currentTimeMillis() + " i = "+ thread.getI());
			
			//B 段
			thread.resume();
			Thread.sleep(5000);
			
			//C 段
			thread.suspend();
			System.out.println("B=" + System.currentTimeMillis() + " i = "+ thread.getI());
			Thread.sleep(5000);
			System.out.println("B=" + System.currentTimeMillis() + " i = "+ thread.getI());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
