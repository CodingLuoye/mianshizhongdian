package com.self.thread.status;
/**执行wait() 方法后线程的状态就是waiting
 * @author Administrator
 *
 */
class Lock{
	public static final Byte lock = new Byte("0");
}
class MyThread extends Thread{
	@Override
	public void run() {
		try {
			synchronized (Lock.lock) {
				Lock.lock.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class Test4 {
	public static void main(String[] args) throws InterruptedException {
		MyThread t1  = new MyThread();
		t1.start();
		Thread.sleep(1000);
		System.out.println("main 方法中的状态2：" + t1.getState());
	}
}
