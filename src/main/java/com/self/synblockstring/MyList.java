package com.self.synblockstring;

import java.util.ArrayList;
import java.util.List;

class MyThreadA extends Thread{
	private MyList list;
	public MyThreadA(MyList list){
		super();
		this.list = list;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			list.add("threadA " + (i+1));
		}
	}
}
class MyThreadB extends Thread{
	private MyList list;
	public MyThreadB(MyList list){
		super();
		this.list = list;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			list.add("threadB " + (i+1));
		}
	}
}

public class MyList {
	@SuppressWarnings("rawtypes")
	private List list = new ArrayList<>();
	@SuppressWarnings("unchecked")
	synchronized public void add(String username){
		System.out.println("ThreadName = " + Thread.currentThread().getName() + " 执行了add方法！ ");
		list.add(username);
		System.out.println("ThreadName = " + Thread.currentThread().getName() + " 退出了add方法！ ");
	}
	synchronized public int getSize(){
		System.out.println("ThreadName = " + Thread.currentThread().getName() + " 执行了getSize方法！ ");
		int sizeValue = list.size();
		System.out.println("ThreadName = " + Thread.currentThread().getName() + " 退出了getSize方法！ ");
		return sizeValue;
	}
	public static void main(String[] args) {
		MyList mylist = new MyList();
		MyThreadA a = new MyThreadA(mylist);
		a.setName("A");
		a.start();
		MyThreadB b = new MyThreadB(mylist);
		b.setName("B");
		b.start();
	}
}
