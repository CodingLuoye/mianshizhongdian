package com.self.thread.channel;
/**
 * join方式是使所属的线程x对象正常执行run方法中的任务，而使当前线程z进行无限期的阻塞，
 * 等待线程x销毁后再继续执行z后面的代码
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		Mythread threadTest = new Mythread();
		threadTest.start();
		threadTest.join();
		System.out.println("我想当threadTest对象执行完毕我再执行");
		System.out.println("但上面代码中的sleep()中的值应该写多少呢");
		System.out.println("答案是：根据不能确定：");
	}
}
class Mythread extends Thread{
	@Override
	public void run() {
		try {
			int secondValue = (int)(Math.random()*10000);
			System.out.println(secondValue);
			Thread.sleep(secondValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}