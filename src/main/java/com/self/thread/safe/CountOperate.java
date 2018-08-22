package com.self.thread.safe;

public class CountOperate extends Thread {
	public CountOperate(){
		System.out.println("CountOperate --- begin");
		System.out.println("Thread.currentThread().getName()=="+Thread.currentThread().getName());
		System.out.println("this.getName() = "+this.getName());
		System.out.println("CountOperate --- end");
	}
	@Override
	public void run() {
		System.out.println("run---begin");
		System.out.println("run=" +this.isAlive());
		System.out.println("Thread.currentThread().getName()=="+Thread.currentThread().getName());
		System.out.println("this.getName() = "+this.getName());
		System.out.println("run --- end");
	}
	public static void main(String[] args) {
		CountOperate c = new CountOperate();
		Thread t1 = new Thread(c);
		t1.setName("A");
		System.out.println("begin == "+t1.isAlive());
		t1.start();
		System.out.println("end == "+t1.isAlive());
	}
}
