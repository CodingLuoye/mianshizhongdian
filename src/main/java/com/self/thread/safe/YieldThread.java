package com.self.thread.safe;
/**
 * yidld()方法的作用是放弃当前的CPU资源，将它让给其它的任务去占用CPU执行时间，但放弃时间不确定
 * @author Administrator
 *
 */
public class YieldThread extends Thread {
	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 50000000; i++) {
			Thread.yield();
			count = count + (i+1);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("用时：" + (endTime - beginTime) + "毫秒！ ");
	}
	public static void main(String[] args) {
		YieldThread thread = new YieldThread();
		thread.start();
	}
}
