package com.self.thread.single;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 使用static创建单例模式
 * @author Administrator
 *
 */
public class Run4 {
	static class MyObject{
		public enum MyEnumSingleton{
			connectionFactory;
			private Connection connection;
			private MyEnumSingleton(){
				try {
					System.out.println("调用了MyObject的构造");
					String url = "jdgc:mysql://localhost:";
					connection = DriverManager.getConnection(url);
				} catch (Exception e) {
				}
			}
			public Connection getConnection(){
				return connection;
			}
		}
		public static Connection getConnection(){
			return MyEnumSingleton.connectionFactory.getConnection();
		}
	}
	static class MyThread extends Thread{
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(MyObject.getConnection().hashCode());
			}
		}
	}
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}
}
