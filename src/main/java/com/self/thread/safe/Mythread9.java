package com.self.thread.safe;

/**
 * 使用suspend暂定线程，resume恢复线程 公共的同步对象的独占,使其它线程无法访问
 * @author Administrator
 *
 */
public class Mythread9 extends Thread {
	private long i = 0;
	@Override
	public void run() {
		while(true){
			i ++ ;
			System.out.println(i);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Mythread9 thread = new Mythread9();
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			System.out.println("main end!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
