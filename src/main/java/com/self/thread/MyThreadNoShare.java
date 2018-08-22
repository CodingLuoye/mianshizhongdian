package com.self.thread;

/**
 * Thread not share data
 * @author Administrator
 *
 */
public class MyThreadNoShare extends Thread {
	
	private int count = 5;
	public MyThreadNoShare(String name){
		super();
		this.setName(name);	//设置线程名称
	}
	@Override
	public void run() {
		super.run();
		while(count>0){
			count --;
			System.out.println("由 "+ MyThreadNoShare.currentThread().getName() + " 计算,count="+count);
		}
	}
	
	public static void main(String[] args) {
		MyThreadNoShare  a = new MyThreadNoShare("A");
		MyThreadNoShare  b = new MyThreadNoShare("B");
		MyThreadNoShare  c = new MyThreadNoShare("C");
		a.start();
		b.start();
		c.start();
	}

}
