package com.self.enumconn;

public class Run {

	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(ConnEnum.connFactory.getConn().hashCode());
				System.out.println(ConnEnum.connFactory.getConn().hashCode());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(ConnEnum.connFactory.getConn().hashCode());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(ConnEnum.connFactory.getConn().hashCode());
				System.out.println(ConnEnum.connFactory.getConn().hashCode());
				System.out.println(ConnEnum.connFactory.getConn().hashCode());
			}
		}).start();

	}

}