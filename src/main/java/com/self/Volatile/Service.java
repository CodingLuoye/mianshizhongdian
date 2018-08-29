package com.self.Volatile;
/**
 * 添加String anyString = new String();
 * synchronized (anyString) {}
 * 保证程序能够正常退出，否则是死循环
 * @author Administrator
 *
 */
public class Service {
	private boolean isContinueRun = true;
	public void runMethod(){
		String anyString = new String();
		while(isContinueRun == true){
			synchronized (anyString) {
				
			}
		}
		System.out.println("停下来了！");
	}
	public void stopMethod(){
		isContinueRun = false;
	}
	public static void main(String[] args) {
		try {
			Service service = new Service();
			ThreadA a = new ThreadA(service);
			a.start();
			Thread.sleep(1000);
			ThreadB b = new ThreadB(service);
			b.start();
			System.out.println("已经发起了停止命令了！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		service.runMethod();
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
		service.stopMethod();
	}
}
