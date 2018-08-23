package com.self.Synchronized;

class ThreadObject2A extends Thread{
	private ObjectService2 service;
	public ThreadObject2A(ObjectService2 service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		super.run();
		service.serviceMethodA();
	}
}

class ThreadObject2B extends Thread{
	private ObjectService2 service;
	public ThreadObject2B(ObjectService2 service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		super.run();
		service.serviceMethodB();
	}
}

public class ObjectService2 {
	public void serviceMethodA(){
		try {
			synchronized (this) {
				System.out.println("A begin time=" + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("A end time=" + System.currentTimeMillis());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void serviceMethodB(){
		synchronized(this){
			System.out.println("B begin time = " + System.currentTimeMillis());
			System.out.println("B end time = " + System.currentTimeMillis());
		}
	}
	
	public static void main(String[] args) {
		ObjectService2 service = new ObjectService2();
		ThreadObject2A a = new ThreadObject2A(service);
		a.setName("A");
		a.start();
		ThreadObject2B b = new ThreadObject2B(service);
		b.setName("B");
		b.start();
	}
}
