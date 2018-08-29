package com.self.waitAndNotify;

/**
 * lock.wait notify会随机唤醒一个线程
 * @author Administrator
 *
 */
public class Service {
	public void testMethod(Object lock){
		try {
			synchronized (lock) {
				System.out.println("begin wait() ThreadName =" +Thread.currentThread().getName());
				lock.wait();
				//Thread.sleep(4000); 变成同步了
				System.out.println("end wait()  ThreadName =" +Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void synNotifyMethod(Object lock){
		try {
			synchronized (lock) {
				System.out.println("begin notify() ThreadName =" +Thread.currentThread().getName()+" time = "+System.currentTimeMillis());
				lock.notify();
				Thread.sleep(5000);
				System.out.println("end notify()  ThreadName =" +Thread.currentThread().getName() +" time = "+System.currentTimeMillis());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		Object lock = new Object();
		ThreadA a = new ThreadA(lock);
		a.start();
		NotifyMethodThread b = new NotifyMethodThread(lock);
		b.start();
		synNotifyMethodThread c = new synNotifyMethodThread(lock);
		c.start();
	}
}
class ThreadA extends Thread{
	private Object lock;
	public ThreadA(Object lock){
		super();
		this.lock = lock;
	}
	@Override
	public void run() {
		Service service = new Service();
		service.testMethod(lock);
	}
}
class NotifyMethodThread extends Thread{
	private Object lock;
	public NotifyMethodThread(Object lock){
		super();
		this.lock = lock;
	}
	@Override
	public void run() {
		Service service = new Service();
		service.synNotifyMethod(lock);
	}
}
class synNotifyMethodThread extends Thread{
	private Object lock;
	public synNotifyMethodThread(Object lock){
		super();
		this.lock = lock;
	}
	@Override
	public void run() {
		Service service = new Service();
		service.synNotifyMethod(lock);
	}
}

class ThreadB extends Thread{
	private Object lock;
	public ThreadB(Object lock){
		super();
		this.lock = lock;
	}
	@Override
	public void run() {
		Service service = new Service();
		service.testMethod(lock);
	}
}