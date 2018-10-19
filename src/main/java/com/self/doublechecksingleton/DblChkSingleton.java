package com.self.doublechecksingleton;

/**
 * 线程安全的单例模式(使用双重同步锁) 因为只能初始化出来一个对象
 * @author Administrator
 *
 */
public class DblChkSingleton {

	private static DblChkSingleton instance;

	private DblChkSingleton() {
		
	}

	public static DblChkSingleton getInstance() {
		if (instance == null) {
			synchronized (DblChkSingleton.class) {
				if (instance == null) { //避免其它的线程进来创建了对象
					instance = new DblChkSingleton();
				}
			}
		}
		return instance;
	}

}
