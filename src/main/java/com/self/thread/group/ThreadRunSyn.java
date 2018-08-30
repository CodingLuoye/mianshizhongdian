package com.self.thread.group;
/**
 * 线程在运行是多个线程之间执行任务的时机是无序的，可以通过改造代码使他们运行时具有有序性
 * @author Administrator
 *
 */
public class ThreadRunSyn {
	static class MyThread extends Thread{
		private Object lock;
		private String showChar;
		private int showNumPosition;
		private int printCount = 0; //统计打印了几个字母
		volatile private static int addNumber = 1;
		public MyThread(Object lock,String showChar,int showNumPosition) {
			super();
			this.lock = lock;
			this.showChar = showChar;
			this.showNumPosition = showNumPosition;
		}
		@Override
		public void run() {
			try {
				synchronized (lock) {
					while(true){
						if(addNumber % 3 == showNumPosition){
							System.out.println("ThreadName =" + Thread.currentThread().getName() + " runCount =" + addNumber + " " + showChar);
							lock.notifyAll();
							addNumber ++;
							printCount ++;
							if(printCount ==3){
								break;
							}
						} else {
							lock.wait();
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Object lock = new Object();
		MyThread a = new MyThread(lock, "A", 1);
		MyThread b = new MyThread(lock, "B", 2);
		MyThread c = new MyThread(lock, "C", 0);
		a.start();
		b.start();
		c.start();
	}
}
