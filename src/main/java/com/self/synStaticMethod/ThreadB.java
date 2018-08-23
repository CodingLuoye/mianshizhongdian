package com.self.synStaticMethod;

public class ThreadB extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Service.printB();
	}
}
