package com.self.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * scheduleAtFixedRate 具备追赶执行性 如果执行任务的时间被延时，那么下次任务的执行时间已上一次
 * 任务的“结束”时间为参考计算
 * 
 * @author Administrator
 *
 */
public class TimerTest6 {
	private static Timer timer = new Timer();
	private static int runCount = 0;
	static public class MyTask1 extends TimerTask{
		@Override
		public void run() {
			try {
				System.out.println("scheduleAtFixedRate begin 运行了！时间为：" + new Date());
				Thread.sleep(5000);
				System.out.println("scheduleAtFixedRate end 运行了！时间为：" + new Date());
				runCount ++;
				if(runCount == 5){
					timer.cancel();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			MyTask1 task = new MyTask1();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2018-08-20 16:29:00";
			Date dateRef = sdf.parse(dateString);
			System.out.println(" 字符串时间：" +dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
			timer.scheduleAtFixedRate(task, dateRef,2000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
