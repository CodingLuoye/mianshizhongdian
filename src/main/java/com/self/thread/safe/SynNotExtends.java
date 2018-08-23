package com.self.thread.safe;

class Main{
	synchronized public void serviceMethod(){
		try {
			System.out.println("int main 下一步 sleep begin threadName = " + Thread.currentThread().getName() + " time=" +System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int main 下一步 sleep end threadName = " + Thread.currentThread().getName() + " time=" +System.currentTimeMillis());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
class Sub extends Main{
	@Override
	public synchronized void serviceMethod() {
		try {
			System.out.println("int sub 下一步 sleep begin threadName = " + Thread.currentThread().getName() + " time=" +System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub 下一步 sleep end threadName = " + Thread.currentThread().getName() + " time=" +System.currentTimeMillis());
			super.serviceMethod();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class ThreadMyA extends Thread{
	private Sub sub;
	public ThreadMyA(Sub sub){
		super();
		this.sub = sub;
	}
	@Override
	public void run() {
		sub.serviceMethod();
	}
}

class ThreadMyB extends Thread{
	private Sub sub;
	public ThreadMyB(Sub sub){
		super();
		this.sub = sub;
	}
	@Override
	public void run() {
		sub.serviceMethod();
	}
}
public class SynNotExtends {
	public static void main(String[] args) {
		Sub subRef = new Sub();
		ThreadMyA a = new ThreadMyA(subRef);
		a.setName("A");
		a.start();
		ThreadMyB b = new ThreadMyB(subRef);
		b.setName("B");
		b.start();
	}
}
