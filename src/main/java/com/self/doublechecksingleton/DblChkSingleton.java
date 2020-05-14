package com.self.doublechecksingleton;

/**
 * 线程安全的单例模式(使用双重同步锁) 因为只能初始化出来一个对象 --恶汉模式
 * @author Administrator
 *
 */
public class DblChkSingleton {
	private volatile static DblChkSingleton instance;
	//使用private构造器，防止其它代码创建对象
	private DblChkSingleton() {
	}
	public static DblChkSingleton getInstance() {
		if (instance == null) {
			synchronized (DblChkSingleton.class) {
				//避免其它的线程进来创建了对象
				if (instance == null) { 
					instance = new DblChkSingleton();
				}
			}
		}
		return instance;
	}
}
