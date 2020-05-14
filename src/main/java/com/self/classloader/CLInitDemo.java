package com.self.classloader;

public class CLInitDemo {
	public static class Hello {
		static{
			System.out.println("hello");
		}
	}
	
	public static void main(String[] args) throws Exception {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		String className = CLInitDemo.class.getName() + "$Hello";
		try {
			Class<?> cls2 = Class.forName(className);
			System.out.println(cls2.getName());
			System.out.println("---------");
			Class<?> cls = cl.loadClass(className);
			cls.newInstance();
			System.out.println(cls.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
