package com.self.classloader;

public class CLInitDemo {
	public static class Hello {
		static{
			System.out.println("hello");
		}
	}
	
	public static void main(String[] args) {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		String className = CLInitDemo.class.getName() + "$Hello";
		try {
			Class<?> cls = cl.loadClass(className);
			Class<?> cls2 = Class.forName(className);
			System.out.println(cls.getName() + cls2.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
