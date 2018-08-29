package com.self.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * schedule(TimerTask taks,long delay) 当前的时间为参考时间，在此基础是延迟指定的毫秒数执行一次TimeTask
 * schedule(TimerTask taks,long delay,long period) 当前时间为参考时间，在此时间的基础上延迟
 * 指定的毫秒数，再以某一间隔时间无限次数地执行某一任务
 * 
 * @author Administrator
 *
 */
public class TimerTest4 {
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			System.out.println("1 begin 运行了！时间为：" + new Date());
		}
	}
	public static void main(String[] args) {
		MyTask task = new MyTask();
		Timer timer = new Timer();
		System.out.println("当前时间： " +new Date());
		timer.schedule(task, 1000,4000);
	}
}
