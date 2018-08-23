package com.self.innerClass;

import com.self.innerClass.OutClass2.InnerClass1.InnerClass2;

public class OutClass2 {
	static class InnerClass1{
		public void method1(InnerClass2 class2){
			String threadName = Thread.currentThread().getName();
			synchronized (class2) {
				System.out.println(threadName + "进入InnerClass1类中的method1方法");
				for (int i = 0; i < 10; i++) {
					System.out.println("i="+i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(threadName + "离开InnerClass1类中的method1方法");
			}
		}
		public synchronized void method2(){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "进入InnerClass1类中的method2方法");
			for (int j = 0; j <= 10; j++) {
				System.out.println("j="+j);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + "离开InnerClass1类中的method2方法");
		}
		
		static class InnerClass2{
			public synchronized void method1(){
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " 进入innerClass2类中的method1方法");
				for (int k = 0; k < 10; k++) {
					System.out.println("k="+k);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(threadName + " 离开innerClass2类中的method1方法");
			}
		}
	}
	
	public static void main(String[] args) {
		final InnerClass1 in1 = new InnerClass1();
		final InnerClass2 in2 = new InnerClass2();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				in1.method1(in2);
			}
		},"T1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				in1.method2();
			}
		},"T2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				in2.method1();
			}
		},"T3");
		t1.start();
		t2.start();
		t3.start();
	}
	
}
