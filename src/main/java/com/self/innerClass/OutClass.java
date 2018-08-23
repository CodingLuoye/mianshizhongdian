package com.self.innerClass;

public class OutClass {
	static class Inner{
		public void method1(){
			synchronized ("其他的锁") {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " i=" +i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		public synchronized void method2(){
			for (int i = 11; i <= 20; i++) {
				System.out.println(Thread.currentThread().getName() + " i=" +i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		final Inner inner = new Inner();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				inner.method1();
			}
		},"A");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				inner.method2();
			}
		},"B");
		t1.start();
		t2.start();
	}
	
}
