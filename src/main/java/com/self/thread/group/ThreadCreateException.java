package com.self.thread.group;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 * setDefaultUncaughtExceptionHandler()对所有线程对象设置异常处理器
 * @author Administrator
 *
 */
public class ThreadCreateException {
	static class MyThread extends Thread{
		@SuppressWarnings("null")
		@Override
		public void run() {
			String username = null;
			System.out.println(username.hashCode());
		}
	} 
	public static void main(String[] args) {
		MyThread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("线程: " +t.getName() + " 出现了异常");
			}
		});
		MyThread t = new MyThread();
		t.setName("线程t");
//		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
//			@Override
//			public void uncaughtException(Thread t, Throwable e) {
//				System.out.println("线程: " +t.getName() + " 出现了异常");
//			}
//		});
		t.start();
		
		MyThread t2 = new MyThread();
		t2.start();
	}
}
