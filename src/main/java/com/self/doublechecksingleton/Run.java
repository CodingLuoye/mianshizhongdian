package com.self.doublechecksingleton;

public class Run {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println(DblChkSingleton.getInstance().hashCode());
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(DblChkSingleton.getInstance().hashCode());
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(DblChkSingleton.getInstance().hashCode());
				System.out.println(DblChkSingleton.getInstance().hashCode());
				System.out.println(DblChkSingleton.getInstance().hashCode());
			}
		}).start();

	}

}
