package com.self.thread.safe;

/**
 * 验证interrupted
 * @author Administrator
 *
 */
public class Mythread3 extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			if(Mythread3.interrupted()){
				System.out.println("已经是停止状态，我要退出了");
				break;
			}
			System.out.println("i="+(i+1));
		}
		System.out.println("我被输出，如果此代码是for 又继续运行，线程并未停止！！！ ");
	}
	
	public static void main(String[] args) {
		try {
			Mythread3 thread = new Mythread3();
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
