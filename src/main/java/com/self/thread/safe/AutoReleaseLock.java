package com.self.thread.safe;

class Service{
	synchronized public void testMethod(){
		if("a".equals(Thread.currentThread().getName())){
			System.out.println("ThreadName=" +Thread.currentThread().getName() + " run beginTime =" + System.currentTimeMillis());
			int i =1;
			while(i==1){
				if("0.123456".equals(("" + Math.random()).substring(0, 8))){
					System.out.println("ThreadName =" +Thread.currentThread().getName() + " run exceptionTime=" + System.currentTimeMillis());
					Integer.parseInt("a");
				}
			}
		}else{
			System.out.println("Thread B run Time = "+  System.currentTimeMillis());
		}
	}
}

class ThreadA extends Thread{
	private Service service;
	
	public ThreadA(Service service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.testMethod();
	}
}
class ThreadB extends Thread{
	private Service service;
	
	public ThreadB(Service service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.testMethod();
	}
	
}
public class AutoReleaseLock {
	public static void main(String[] args) {
		try {
			Service service = new Service();
			ThreadA a = new ThreadA(service);
			a.setName("a");
			a.start();
			Thread.sleep(500);
			ThreadB b = new ThreadB(service);
			b.setName("b");
			b.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
