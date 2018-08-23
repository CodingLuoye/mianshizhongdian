package com.self.synBlockString;

public class Service {
	@SuppressWarnings("unused")
	private String usernameParam;
	@SuppressWarnings("unused")
	private String passwordParam;
	private String anyString = new String();
	public void setUsernamePassword(String username,String password){
		try {
			String anyString = new String();
			synchronized (anyString){
				System.out.println("线程名称为：" +Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "进入同步快");
				usernameParam = username;
				Thread.sleep(3000);
				passwordParam = password;
				System.out.println("线程名称为：" +Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "离开同步快");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void a(){
		try {
			synchronized (anyString) {
				System.out.println("a begin");
				Thread.sleep(3000);
				System.out.println("a end");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	synchronized public void b(){
		System.out.println("b begin");
		System.out.println("b end");
	}
	
}
