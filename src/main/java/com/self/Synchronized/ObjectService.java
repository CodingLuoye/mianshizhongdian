package com.self.Synchronized;

class ThreadObjectA extends Thread{
	private ObjectService service;
	public ThreadObjectA(ObjectService service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		super.run();
		service.serviceMethod();
	}
}

class ThreadObjectB extends Thread{
	private ObjectService service;
	public ThreadObjectB(ObjectService service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		super.run();
		service.serviceMethod();
	}
}

public class ObjectService {
	public void serviceMethod(){
		try {
			synchronized (this) {
				System.out.println("begin time=" + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("end time=" + System.currentTimeMillis());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		ObjectService service = new ObjectService();
		ThreadObjectA a = new ThreadObjectA(service);
		a.setName("A");
		a.start();
		ThreadObjectB b = new ThreadObjectB(service);
		b.setName("B");
		b.start();
	}
}
