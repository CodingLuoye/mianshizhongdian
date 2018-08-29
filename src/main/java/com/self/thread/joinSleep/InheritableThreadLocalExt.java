package com.self.thread.joinSleep;

import java.util.Date;

class Tools{
	public static InheritableThreadLocalExt t1 = new InheritableThreadLocalExt();
}
class ThreadTool extends Thread{
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("在线程a中取值="+Tools.t1.get());
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
@SuppressWarnings("rawtypes")
public class InheritableThreadLocalExt extends InheritableThreadLocal {
	@Override
	protected Object initialValue() {
		return new Date().getTime();
	}
	
	@Override
	protected Object childValue(Object parentValue) {
		return parentValue + "我在子线程加的~";
	}
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("   在Main线程中取值 =" +Tools.t1.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			ThreadTool a = new ThreadTool();
			a.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
