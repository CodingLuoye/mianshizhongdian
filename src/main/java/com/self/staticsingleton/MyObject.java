package com.self.staticsingleton;

public class MyObject {
	private static MyObject instance = new MyObject();

	private MyObject() {

	}
	
	public static MyObject getInstance() {
		return instance;
	}
}
