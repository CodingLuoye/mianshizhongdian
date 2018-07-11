package com.self.doublechecksingleton;

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
