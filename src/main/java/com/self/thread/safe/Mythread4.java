package com.self.thread.safe;

/**
 * 验证interrupted
 * @author Administrator
 *
 */
public class Mythread4 extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if(Mythread4.interrupted()){
					System.out.println("已经是停止状态，我要退出了");
					throw new InterruptedException();
				}
				System.out.println("i="+(i+1));
			}
			System.out.println("我在for下面 ");
		} catch (Exception e) {
			System.out.println("进Mythread4.java 类run方法中的catch了");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Mythread4 thread = new Mythread4();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
