package com.self.classLoader;

public class ClassLoadDemo {
	public static void main(String[] args) {
		ClassLoader cl = ClassLoadDemo.class.getClassLoader();
		while(cl !=null){
			System.out.println(cl.getClass().getName());
			cl = cl.getParent();
		}
		System.out.println(String.class.getClassLoader());
		
		//输出:	sun.misc.Launcher$AppClassLoader
		//		sun.misc.Launcher$ExtClassLoader
		//		null
		
		ClassLoader clnew = ClassLoader.getSystemClassLoader();
		try {
			Class<?> cls = clnew.loadClass("java.util.ArrayList");
			ClassLoader actualLoader = cls.getClassLoader();
			System.out.println(actualLoader);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
