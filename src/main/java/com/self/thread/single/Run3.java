package com.self.thread.single;
/**
 * 使用static创建单例模式
 * @author Administrator
 *
 */
public class Run3 {
	static class MyObject{
		private static MyObject instance = null;
		private MyObject(){
		}
		static {
			instance = new MyObject();
		}
		public static MyObject getInstance(){
			return instance;
		}
	}
	static class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println(MyObject.getInstance().hashCode());
		}
	}
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}
}
