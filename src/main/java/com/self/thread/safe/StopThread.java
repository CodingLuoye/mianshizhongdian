package com.self.thread.safe;

class SynchronizedObject{
	private String username = "a";
	private String password = "aa";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	synchronized public void printString(String username,String password){
		try {
			this.username = username;
			Thread.sleep(100000);
			this.password = password;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/**
 * 使用stop方法造成的数据不一致问题
 * @author Administrator
 *
 */
public class StopThread extends Thread {
	private SynchronizedObject object;
	public StopThread(SynchronizedObject object){
		super();
		this.object = object;
	}
	@Override
	public void run() {
		object.printString("b", "bb");
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			SynchronizedObject object = new SynchronizedObject();
			StopThread thread = new StopThread(object);
			thread.start();
			Thread.sleep(500);
			thread.stop();
			System.out.println(object.getUsername() + " " + object.getPassword());
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
