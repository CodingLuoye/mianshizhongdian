package com.self.thread.safe;

/**
 * 使用suspend与resume方法的缺点----不同步
 * @author Administrator
 *
 */
class MyObject{
	private String username = "1";
	private String password = "11";
	
	@SuppressWarnings("deprecation")
	public void setValue(String u,String p){
		this.username = u;
		if("a".equals(Thread.currentThread().getName())){
			System.out.println("停止a线程");
			Thread.currentThread().suspend();
		}
		this.password = p;
	}
	public void printUsernamePassword(){
		System.out.println(username + " " +password);
	}
}

public class Mythread10 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		final MyObject myobject = new MyObject();
		Thread  thread1 = new Thread(){
			@Override
			public void run() {
				myobject.setValue("a","aa");
			}
		};
		thread1.setName("a");
		thread1.start();
		Thread.sleep(500);
		Thread  thread2 = new Thread(){
			@Override
			public void run() {
				myobject.printUsernamePassword();
			}
		};
		thread2.start();
	}
	
}
