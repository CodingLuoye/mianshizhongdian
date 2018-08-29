package com.self.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 有时Timer类中的cancel()方法并没有抢到queue锁，所以TimerTask类中任务继续正常执行
 * @author Administrator
 *
 */
public class TimeCancle {
	static int i = 0;
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			System.out.println("正常执行了 "+i);
		}
	}
	
	public static void main(String[] args) {
		while(true){
			try {
				i++;
				Timer timer = new Timer();
				MyTask task = new MyTask();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = "2018-08-29 16:02:00";
				Date dateRef = sdf.parse(dateString);
				timer.schedule(task, dateRef);
				timer.cancel();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
