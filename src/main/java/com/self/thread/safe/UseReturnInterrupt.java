package com.self.thread.safe;
/**
 * 使用return终止线程
 * @author Administrator
 *
 */
public class UseReturnInterrupt extends Thread{
	@Override
	public void run() {
		while(true){
			if(this.isInterrupted()){
				System.out.println("停止了");
				return;
			}
			System.out.println("timer = " + System.currentTimeMillis());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		UseReturnInterrupt t = new UseReturnInterrupt();
		t.start();
		Thread.sleep(2000);
		t.interrupt();
	}
}
