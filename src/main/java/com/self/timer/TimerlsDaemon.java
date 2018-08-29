package com.self.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 一个Timer可以有多个schedule
 * 
 * @author Administrator
 *
 */
public class TimerlsDaemon {
	private static Timer timer = new Timer();
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			System.out.println("1运行了！时间为：" + new Date());
		}
	}
	static public class MyTask2 extends TimerTask{
		@Override
		public void run() {
			System.out.println("2运行了！时间为：" + new Date());
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			MyTask2 task2 = new MyTask2();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2018-08-29 15:53:00";
			Date dateRef = sdf.parse(dateString);
			System.out.println("字符串时间：" +dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
			timer.schedule(task, dateRef,4000);
			String dateString2 = "2018-08-29 15:54:00";
			Date dateRef2= sdf.parse(dateString2);
			System.out.println("字符串时间：" +dateRef2.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
			timer.schedule(task2, dateRef2,4000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
