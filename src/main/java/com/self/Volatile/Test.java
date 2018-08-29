package com.self.Volatile;

import java.util.ArrayList;
import java.util.List;

class MyList{
	private static List<String> list = new ArrayList<>();
	public static void add(){
		list.add("高岩松");
	}
	public static int size(){
		return list.size();
	}
}
class ThreadAA extends Thread{
	private Object lock;
	public ThreadAA(Object lock){
		super();
		this.lock = lock;
	}
	@Override
	public void run() {
		try {
			synchronized (lock) {
				if(MyList.size() != 5){
					System.out.println("wait begin " + System.currentTimeMillis());
					lock.wait();
					System.out.println("wait end " + System.currentTimeMillis());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class ThreadBB extends Thread{
	private Object lock;
	public ThreadBB(Object lock){
		super();
		this.lock = lock;
	}
	@Override
	public void run() {
		try {
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					MyList.add();
					if(MyList.size() == 5){
						lock.notify();
						System.out.println("已发出通知");
					}
					System.out.println("添加了 "+(i+1)+" 个元素");
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class Test {
	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		ThreadAA a = new ThreadAA(lock);
		a.setName("AA");
		a.start();
		Thread.sleep(50);
		ThreadBB b = new ThreadBB(lock);
		b.setName("BB");
		b.start();
	}
}
