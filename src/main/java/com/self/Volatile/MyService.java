package com.self.Volatile;

import java.util.concurrent.atomic.AtomicLong;
class Mythread1 extends Thread{
	private MyService myService;
	public Mythread1(MyService myService){
		super();
		this.myService = myService;
	}
	@Override
	public void run() {
		myService.addNum();
	}
}
/**
 * AtomicLong 的使用  addAndGet
 * @author Administrator
 *
 */
public class MyService {
	public static AtomicLong aiRef = new AtomicLong();
	synchronized public void addNum(){
		System.out.println(Thread.currentThread().getName() + "加了100之后的值是："+aiRef.addAndGet(100));
		aiRef.addAndGet(1);
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try {
			MyService service = new MyService();
			Mythread1[] array = new Mythread1[5];
			for (int i = 0; i < array.length; i++) {
				array[i] = new Mythread1(service);
				array[i].start();
			}
			Thread.sleep(1000);
			System.out.println(MyService.aiRef.get());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
