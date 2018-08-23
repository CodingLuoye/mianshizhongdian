package com.self.synStaticMethod;

class StopService{
	Object object1 = new Object();
	public void methodA(){
		synchronized (object1) {
			System.out.println("methodA begin");
			boolean isContineuRun = true;
			while(isContineuRun){
				
			}
			System.out.println("methodA end");
		}
	}
	Object object2 = new Object();
	public void methodB(){
		synchronized (object2) {
			System.out.println("methodB begin");
			System.out.println("methodB end");
		}
	}
}
class StopThreadA extends Thread{
	private StopService service;
	public StopThreadA(StopService service){
		super();
		this.service = service;
	}
	@Override
	public void run(){
		service.methodA();
	}
}
class StopThreadB extends Thread{
	private StopService service;
	public StopThreadB(StopService service){
		super();
		this.service = service;
	}
	@Override
	public void run(){
		service.methodB();
	}
}
public class TwoStop {
	public static void main(String[] args) {
		StopService service = new StopService();
		StopThreadA athread = new StopThreadA(service);
		athread.start();
		StopThreadB bthread = new StopThreadB(service);
		bthread.start();
	}
}
