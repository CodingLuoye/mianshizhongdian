package com.self.waitandnotify;

public class Test1 {
	public static void main(String[] args) {
		try {
			String newString =new String();
			System.out.println("syn上面");
			synchronized (newString) {
				System.out.println("syn第一行");
				newString.wait();
				System.out.println("wait下的代码！");
			}
			System.out.println("syn下面的代码");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
