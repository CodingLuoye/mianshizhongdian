package com.self.setNewPropertiesLockOne;

public class Service {
	public void serviceMethodA(Userinfo userInfo){
		synchronized (userInfo) {
			try {
				System.out.println(Thread.currentThread().getName());
				userInfo.setUsername("abcabcabc");
				Thread.sleep(3000);
				System.out.println("end！ time =" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
