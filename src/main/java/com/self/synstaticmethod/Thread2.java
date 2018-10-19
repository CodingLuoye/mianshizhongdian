package com.self.synstaticmethod;

public class Thread2 extends Thread {
	private Service service;
	public Thread2(Service service){
		super();
		this.service = service;
	}
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		service.printB();
	}
}
