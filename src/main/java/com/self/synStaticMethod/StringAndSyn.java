package com.self.synStaticMethod;
/**
 * 使用String字符串造成的同一个锁对象
 * @author Administrator
 *
 */
class StringService{
	public static void print(String stringParam){
		try {
			synchronized (stringParam) {
				while(true){
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class StringThreadA extends Thread{
	private StringService service;
	public StringThreadA(StringService service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.print("AA");
	}
}
class StringThreadB extends Thread{
	private StringService service;
	public StringThreadB(StringService service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.print("AA");
	}
}
public class StringAndSyn {
	public static void main(String[] args) {
		StringService service = new StringService();
		StringThreadA a = new StringThreadA(service);
		a.setName("A");
		a.start();
		StringThreadB b = new StringThreadB(service);
		b.setName("B");
		b.start();
	}
}
