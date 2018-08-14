package com.self.doublechecksingleton;

/**
 * 线程安全的单例模式
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
				if (instance == null) {
					instance = new DblChkSingleton();
				}
			}
		}
		return instance;
	}

}
