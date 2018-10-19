package com.self.doublechecksingleton;

public class SynSingleton {

	private static SynSingleton instance;
	
	private SynSingleton(){
		
	}
	
	public static synchronized SynSingleton getInstance(){ //对获取实例的方法进行同步
		if(instance == null){
			instance = new SynSingleton();
		}
		return instance;
	}
}
