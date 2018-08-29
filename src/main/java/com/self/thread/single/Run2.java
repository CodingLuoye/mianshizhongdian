package com.self.thread.single;
/**
 * 懒汉模式多线程下可能出现多个实例
 * @author Administrator
 *
 */
public class Run2 {
	static class MyObject{
		private static MyObject myObject;
		private MyObject(){
		}
		public static MyObject getInstance(){
			if(myObject !=null){
			}else{
				synchronized (MyObject.class) {
					if(myObject == null){
						myObject = new MyObject();
					}
				}
			}
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
