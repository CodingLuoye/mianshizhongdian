package com.self.thread.group;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
	static class MyThread extends Thread{
		@SuppressWarnings("unused")
		private SimpleDateFormat sdf;
		private String dateString;
		public MyThread(SimpleDateFormat sdf,String dateString) {
			super();
			this.sdf = sdf;
			this.dateString = dateString;
		}
		@Override
		public void run() {
			try {
				Date dateRef = DateTools.getSimpleDateFormat("yyyy-MM-dd").parse(dateString);
				String newDateString = DateTools.getSimpleDateFormat("yyyy-MM-dd").format(dateRef).toString();
				if(!newDateString.equals(dateString)){
					System.out.println("ThreadName = " + this.getName() + "报错了 日期字符串 ：" + dateString + "转换成的日期为：" + newDateString);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	static class DateTools{
		private static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();
		public static SimpleDateFormat getSimpleDateFormat(String datePattern){
			SimpleDateFormat sdf = null;
			sdf = t1.get();
			if(sdf ==null){
				sdf = new SimpleDateFormat(datePattern);
				t1.set(sdf);
			}
			return sdf;
		}
	}
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] dateStringArray = new String[]{"2000-01-01","2000-01-02","2000-01-03","2000-01-04"
				,"2000-01-05","2000-01-06","2000-01-07","2000-01-08","2000-01-09","2000-01-10"};
		MyThread[] threadArray = new MyThread[10];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new MyThread(sdf, dateStringArray[i]);
			threadArray[i].start();
		}
	}
}
