package com.self.Synchronized;

class MyThreadA extends Thread {
	private Task2 task;
	public MyThreadA(Task2 task){
		super();
		this.task = task;
	}
	@Override
	public void run() {
		super.run();
		task.doLongTimeTask();
	}
}
class MyThreadB extends Thread {
	private Task2 task;
	public MyThreadB(Task2 task){
		super();
		this.task = task;
	}
	@Override
	public void run() {
		super.run();
		task.doLongTimeTask();
	}
}
public class Task2 {
	public void doLongTimeTask(){
		for (int i = 0; i < 100; i++) {
			System.out.println("nosynchronized threadName=" + Thread.currentThread().getName() + " i =" + (i+1));
		}
		System.out.println(" ");
		synchronized(this){
			for (int j = 0; j < 100; j++) {
				System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " j =" + (j+1));
			}
		}
	}
	
	public static void main(String[] args) {
		Task2 task = new Task2();
		MyThreadA thread1 = new MyThreadA(task);
		thread1.start();
		MyThreadB thread2 = new MyThreadB(task);
		thread2.start();
	}
}
