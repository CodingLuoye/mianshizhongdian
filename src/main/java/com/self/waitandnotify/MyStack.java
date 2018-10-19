package com.self.waitandnotify;

import java.util.ArrayList;
import java.util.List;

class P_thread extends Thread{
	private P p;
	public P_thread(P p){
		super();
		this.p = p;
	}
	@Override
	public void run() {
		while(true){
			p.pushService();
		}
	}
}
class C_thread extends Thread{
	private C c;
	public C_thread(C c){
		super();
		this.c = c;
	}
	@Override
	public void run() {
		while(true){
			c.popService();
		}
	}
}
class P{
	private MyStack mystack;
	public P(MyStack mystack){
		super();
		this.mystack = mystack;
	}
	public void pushService(){
		mystack.push();
	}
}
class C{
	private MyStack mystack;
	public C(MyStack mystack){
		super();
		this.mystack = mystack;
	}
	public void popService(){
		mystack.pop();
	}
}
public class MyStack {
	private List<String> list = new ArrayList<>();
	synchronized public void push(){
		try {
			if(list.size() == 1){
				this.wait();
			}
			list.add("anyString==" + Math.random());
			this.notify();
			System.out.println("push=" +list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public String pop(){
		String returnValue = "";
		try {
			if(list.size() == 0){
				System.out.println("pop操作中的："+Thread.currentThread().getName() + "线程呈wait状态");
				this.wait();
			}
			returnValue = "" + list.get(0);
			this.notify();
			System.out.println("pop=" +list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		P p = new P(myStack);
		P p1 = new P(myStack);
		P p2 = new P(myStack);
		P p3 = new P(myStack);
		C c1 = new C(myStack);
		P_thread pThread = new P_thread(p);
		P_thread p1Thread = new P_thread(p1);
		P_thread p2Thread = new P_thread(p2);
		P_thread p3Thread = new P_thread(p3);
		C_thread c1Thread = new C_thread(c1);
		pThread.start();
		p1Thread.start();
		p2Thread.start();
		p3Thread.start();
		c1Thread.start();
	}
}
