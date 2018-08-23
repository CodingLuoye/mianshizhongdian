package com.self.Synchronized;

class MyThread3 extends Thread {
	private Task3 task;
	public MyThread3(Task3 task){
		super();
		this.task = task;
	}
	@Override
	public void run() {
		super.run();
		task.doLongTimeTask();
	}
}
class MyThread4 extends Thread {
	private Task3 task;
	public MyThread4(Task3 task){
		super();
		this.task = task;
	}
	@Override
	public void run() {
		super.run();
		task.otherMethod();
	}
}
/**
 * synchronized(this) 代码块锁定的当前对象的
 * @author Administrator
 *
 */
public class Task3 {
	public void otherMethod(){
		System.out.println("-----------------------run ----------otherMethod");
	}
	public void doLongTimeTask(){
		synchronized(this){
			for (int j = 0; j < 10000; j++) {
				System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " j =" + (j+1));
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Task3 task = new Task3();
		MyThread3 thread1 = new MyThread3(task);
		thread1.start();
		Thread.sleep(100);
		MyThread4 thread2 = new MyThread4(task);
		thread2.start();
	}
}
