package com.self.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * run方法执行了，但是线程一直在运行 如果传入的时间早于当前时间，则立马执行
 * @author Administrator
 *
 */
public class timerTest1 {
	private static Timer timer = new Timer();
	//private static Timer timer = new Timer(true); //如果设置为daemon则程序只会执行一次
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			System.out.println("运行了！时间为：" + new Date());
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2018-08-12 11:55:00";
			Date dateRef = sdf.parse(dateString);
			System.out.println("字符串时间：" +dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
			timer.schedule(task, dateRef);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
