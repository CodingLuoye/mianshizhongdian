package com.self.thread.safe;

/**
 * 使用suspend暂定线程，resume恢复线程 公共的同步对象的独占,使其它线程无法访问
 * @author Administrator
 *
 */
class SynchroinzedObject{
	@SuppressWarnings("deprecation")
	synchronized public void printString(){
		System.out.println("begin");
		if("a".equals(Thread.currentThread().getName())){
			System.out.println("a线程永远 suspend了");
			Thread.currentThread().suspend();
		}
		System.out.println("end");
	}
}

public class Mythread8 extends Thread {
	public static void main(String[] args) {
		try {
			final SynchroinzedObject object = new SynchroinzedObject();
			Thread thread1 = new Thread(){
				@Override
				public void run() {
					object.printString();
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(1000);
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					System.out.println("thread2 启动了,但进入不了printString()方法!只打印一个begin");
					System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了");
					object.printString();
				}
			};
			thread2.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
