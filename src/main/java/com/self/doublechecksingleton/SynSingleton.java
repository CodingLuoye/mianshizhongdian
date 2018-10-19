package com.self.doublechecksingleton;

public class SynSingleton {

	private static SynSingleton instance;
	
	private SynSingleton(){
		
	}
	/**
	 * 对获取实例的方法进行同步
	 * 使用synchronized保证每次获取实例的线程只有一个,这样就不会创建多个实例
	 * @return
	 */
	public static synchronized SynSingleton getInstance(){ 
		if(instance == null){
			instance = new SynSingleton();
		}
		return instance;
	}
}
