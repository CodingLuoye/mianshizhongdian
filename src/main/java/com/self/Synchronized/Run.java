package com.self.Synchronized;

public class Run {
	public static void main(String[] args) {
		Task task = new Task();
		MyThread1 thread1 = new MyThread1(task);
		thread1.start();
		MyThread2 thread2 = new MyThread2(task);
		thread2.start();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		long beginTime = CommonUtis.beginTime1;
		if(CommonUtis.beginTime2 < CommonUtis.beginTime1){
			beginTime = CommonUtis.beginTime2;
		}
		long endTime = CommonUtis.endTime1;
		if(CommonUtis.endTime2 > CommonUtis.endTime1){
			endTime = CommonUtis.endTime2;
		}
		System.out.println("耗时 :" + (endTime-beginTime)/10);
	}
}
