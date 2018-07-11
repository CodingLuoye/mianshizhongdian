package com.self.staticsingleton;

public class Run {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println(MyObject.getInstance().hashCode());
				System.out.println(MyObject.getInstance().hashCode());
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(MyObject.getInstance().hashCode());
				System.out.println(MyObject.getInstance().hashCode());
				
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(MyObject.getInstance().hashCode());
				System.out.println(MyObject.getInstance().hashCode());
				System.out.println(MyObject.getInstance().hashCode());
				
			}
		}).start();
	}
}
