package com.self.synstaticmethod;

public class ThreadA extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Service.printA();
	}
}
