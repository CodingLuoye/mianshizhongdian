package com.self.thread.group;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 * 如果对象和类上都有异常，抛出对象的异常
 * 如果对象上没有异常，类上有异常 抛出类异常
 * 如果线程在线程组里面，对象和类都有异常  抛出对象异常
 * 如果线程在线程组里面，类上面有异常 抛出类异常，线程组异常
 * 如果线程在线程组里面，对象和类上面都没有异常， 抛出线程组异常
 * @author Administrator
 *
 */
public class threadExceptionMove {
	static class MyThread extends Thread{
		private String num = "a";
		public MyThread(){
			super();
		}
		public MyThread(ThreadGroup group,String name){
			super(group,name);
		}
		@Override
		public void run() {
			int numInt = Integer.parseInt(num);
			System.out.println("在线程中打印： " + (numInt +1));
		}
	}
	
	static class MyThreadGroup extends ThreadGroup{
		public MyThreadGroup(String name){
			super(name);
		}
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			super.uncaughtException(t, e);
			System.out.println("线程组的异常处理");
			e.printStackTrace();
		}
	}
	
	static class ObjectUncaughtExceptionHandler implements UncaughtExceptionHandler{
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("对象的异常处理");
			e.printStackTrace();
		}
	}
	
	static class StateUncaughtExceptionHandler implements UncaughtExceptionHandler{
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("静态的异常处理");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyThreadGroup group = new MyThreadGroup("我的线程组");
		MyThread myThread = new MyThread(group,"我的线程");
//		MyThread myThread = new MyThread();
//		myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
//		MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		myThread.start();
	}
}
