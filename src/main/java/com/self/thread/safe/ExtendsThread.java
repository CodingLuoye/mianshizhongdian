package com.self.thread.safe;

class Father{
	public int i = 10;
	synchronized public void oprateFatherMethod(){
		try {
			i--;
			System.out.println("father print i="+i);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class Son extends Father{
	synchronized public void oprateSonMethod(){
		try {
			while(i>0){
				i--;
				System.out.println("sub print i="+i);
				Thread.sleep(100);
				this.oprateFatherMethod();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/**
 * 当存在父子类继承关系时，子类是完全可以通过"可重入锁"调用父类的同步方法的
 * @author Administrator
 *
 */
public class ExtendsThread extends  Thread {
	@Override
	public void run() {
		Son son = new Son();
		son.oprateSonMethod();
	}
	public static void main(String[] args) {
		ExtendsThread t = new ExtendsThread();
		t.start();
	}
}
