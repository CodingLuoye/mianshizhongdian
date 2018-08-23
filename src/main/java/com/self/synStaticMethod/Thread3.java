package com.self.synStaticMethod;

public class Thread3 extends Thread {
	private Service service;
	public Thread3(Service service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.printC();
	}
}
