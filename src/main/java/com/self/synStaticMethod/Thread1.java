package com.self.synStaticMethod;

public class Thread1 extends Thread {
	private Service service;
	public Thread1(Service service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.printA();
	}
}
