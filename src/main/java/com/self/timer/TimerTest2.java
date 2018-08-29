package com.self.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * schedule(TimerTask task,Date firstTime,long period)
 * 在指定的日期之后，间隔周期性的无限循环执行某一任务
 * 时间可能会被延迟
 * TimerTask 类中的cancel() 方法是将自身从任务队列中清除
 * timer中的cancel是将任务队列中的全部任务清空,并且进程被销毁
 * @author Administrator
 *
 */
public class TimerTest2 {
	private static Timer timer = new Timer();
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			System.out.println("1 begin 运行了！时间为：" + new Date());
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2018-08-29 16:02:00";
			Date dateRef = sdf.parse(dateString);
			System.out.println("字符串时间：" +dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
			timer.schedule(task, dateRef,4000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
