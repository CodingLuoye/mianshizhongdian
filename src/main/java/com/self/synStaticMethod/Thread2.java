package com.self.synStaticMethod;

public class Thread2 extends Thread {
	private Service service;
	public Thread2(Service service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.printB();
	}
}
