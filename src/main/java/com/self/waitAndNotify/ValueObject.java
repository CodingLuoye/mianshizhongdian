package com.self.waitAndNotify;

import java.util.ArrayList;
import java.util.List;
class Add{
	private String lock;
	public Add(String lock){
		super();
		this.lock = lock;
	}
	public void add(){
		synchronized (lock) {
			ValueObject.list.add("anyString");
			lock.notifyAll();
		}
	}
}
class Subtract{
	private String lock;
	public Subtract(String lock){
		super();
		this.lock = lock;
	}
	public void subtract(){
		try {
			synchronized (lock) {
				while(ValueObject.list.size() == 0){
					System.out.println("wait begin ThreadName =" + Thread.currentThread().getName());
					lock.wait();
					System.out.println("wait end ThreadName =" + Thread.currentThread().getName());
				}
				ValueObject.list.remove(0);
				System.out.println("list size = " + ValueObject.list.size());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class ThreadAA extends Thread{
	private Add p;
	public ThreadAA(Add p){
		super();
		this.p = p;
	}
	@Override
	public void run() {
		p.add();
	}
}
class ThreadSubstract extends Thread{
	private Subtract t;
	public ThreadSubstract(Subtract t){
		super();
		this.t = t;
	}
	@Override
	public void run() {
		t.subtract();
	}
}
public class ValueObject {
	public static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		String lock = new String("");
		Add add = new Add(lock);
		Subtract subtract = new Subtract(lock);
		ThreadSubstract sub1 = new ThreadSubstract(subtract);
		sub1.setName("sub1");
		sub1.start();
		ThreadSubstract sub2 = new ThreadSubstract(subtract);
		sub2.setName("sub2");
		sub2.start();
		Thread.sleep(1000);
		ThreadAA addThread = new ThreadAA(add);
		addThread.setName("addThread");
		addThread.start();
		
		
	}
}
