package com.self.thread.single;

public class Run {
	static class MyObject{
		private static MyObject myObject = new MyObject();
		private MyObject(){
		}
		public static MyObject getInstance(){
			//此代码为立即加载
			//此版本的缺点是不能有其他实例变量
			//getInstance()方法没有同步，可能出现非线程安全问题
			return myObject;
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
