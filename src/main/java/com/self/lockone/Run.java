package com.self.lockone;

class ThreadA extends Thread{
	private Service service;
	private Userinfo userinfo;
	public ThreadA(Service service,Userinfo userinfo){
		super();
		this.service = service;
		this.userinfo = userinfo;
	}
	@Override
	public void run() {
		service.serviceMethodA(userinfo);
	}
}
class ThreadB extends Thread{
	private Service service;
	private Userinfo userinfo;
	public ThreadB(Service service,Userinfo userinfo){
		super();
		this.service = service;
		this.userinfo = userinfo;
	}
	@Override
	public void run() {
		service.serviceMethodA(userinfo);
	}
}
public class Run {
	public static void main(String[] args) {
		try {
			Service service = new Service();
			Userinfo userinfo = new Userinfo();
			ThreadA a = new ThreadA(service, userinfo);
			a.setName("A");
			a.start();
			Thread.sleep(50);
			ThreadB b = new ThreadB(service, userinfo);
			b.setName("B");
			b.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
