package com.self.thread.group;

public class ThreadGroupException {
	static class MyThreadGroup extends ThreadGroup{
		public MyThreadGroup(String name){
			super(name);
		}
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			super.uncaughtException(t, e);
			this.interrupt();
		}
	}
	static class MyThread extends Thread{
		private String num;
		public MyThread(ThreadGroup group,String name,String num) {
			super(group,name);
			this.num = num;
		}
		@SuppressWarnings("unused")
		@Override
		public void run() {
			int numInt = Integer.parseInt(num);
			while(this.isInterrupted() == false){
				System.out.println("死循环中： " + Thread.currentThread().getName());
			}
		}
	}
	
	public static void main(String[] args) {
		MyThreadGroup group = new MyThreadGroup("我的线程组");
		MyThread[] myThread = new MyThread[5];
		for (int i = 0; i < myThread.length; i++) {
			myThread[i] = new MyThread(group, "线程 " + (i+1), "1");
			myThread[i].start();
		}
		MyThread newT = new MyThread(group, "报错线程", "a");
		newT.start();
	}
}
