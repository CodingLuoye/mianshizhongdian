package com.self.classloader;

/**
 * ClassLoader加载器demo
 * JDK默认提供
 * Bootsrp loader
 * Bootstrp加载器是用C++语言写的，它是在Java虚拟机启动后初始化的，它主要负责加载%JAVA_HOME%/jre/lib,-Xbootclasspath参数指定的路径以及%JAVA_HOME%/jre/classes中的类。
 * 
 * ExtClassLoader
 * Bootstrp loader加载ExtClassLoader,并且将ExtClassLoader的父加载器设置为Bootstrp loader.ExtClassLoader是用Java写的，
 * 具体来说就是 sun.misc.Launcher$ExtClassLoader，ExtClassLoader主要加载%JAVA_HOME%/jre/lib/ext，
 * 此路径下的所有classes目录以及java.ext.dirs系统变量指定的路径中类库。
 * 
 * AppClassLoader
 * Bootstrp loader加载完ExtClassLoader后，就会加载AppClassLoader,并且将AppClassLoader的父加载器指定为 ExtClassLoader。
 * AppClassLoader也是用Java写成的，它的实现类是 sun.misc.Launcher$AppClassLoader，另外我们知道ClassLoader中有个getSystemClassLoader方法,此方法返回的正是AppclassLoader.
 * AppClassLoader主要负责加载classpath所指定的位置的类或者是jar文档，它也是Java程序默认的类加载器。
 * 
 * @author Administrator
 *
 */
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
