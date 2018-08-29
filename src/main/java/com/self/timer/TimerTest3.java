package com.self.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * TimeTask是以队列的方式一个个被顺序执行，所以执行的时间有可能和预期的时间不一致，后面的任务运行
 * 时间可能会被延迟
 * 
 * @author Administrator
 *
 */
public class TimerTest3 {
	private static Timer timer = new Timer();
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			try {
				System.out.println("1 begin 运行了！时间为：" + new Date());
				Thread.sleep(20000);
				System.out.println("1 end 运行了！时间为：" + new Date());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static public class MyTask2 extends TimerTask{
		@Override
		public void run() {
			System.out.println("2 begin 运行了！时间为：" + new Date());
			System.out.println("运行了，时间为：" + new Date());
			System.out.println("2 begin 运行了！时间为：" + new Date());
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			MyTask2 task2 = new MyTask2();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2018-08-29 15:56:00";
			Date dateRef = sdf.parse(dateString);
			System.out.println("字符串时间：" +dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
			timer.schedule(task, dateRef);
			String dateString2 = "2018-08-29 15:57:00";
			Date dateRef2= sdf.parse(dateString2);
			System.out.println("字符串时间：" +dateRef2.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
			timer.schedule(task2, dateRef2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
