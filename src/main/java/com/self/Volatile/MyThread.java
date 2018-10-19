package com.self.Volatile;
/**
 * volatile增加了实例变量在多个线程之间的可见性，但不具备原子性
 * @author Administrator
 *
 */
public class MyThread extends Thread {
	volatile public static int count;
	/**一定要添加static关键字
	*  synchronized 与static 锁的内容就是MyThread.class类呢如果没有synchronized
	*  输出的结果不具备原子性
	*/
	synchronized private static void addCount(){
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count="+count);
	}
	@Override
	public void run() {
		addCount();
	}
	public static void main(String[] args) {
		MyThread[] mythreadArray = new MyThread[100];
		for (int i = 0; i < 100; i++) {
			mythreadArray[i] = new MyThread();
			mythreadArray[i].start();
		}
	}
}
