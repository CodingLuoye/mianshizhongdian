package com.self.synStaticMethod;

public class ThreadA extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Service.printA();
	}
}
