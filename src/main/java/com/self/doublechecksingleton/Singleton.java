package com.self.doublechecksingleton;
/**
 * 多线程安全的额单例模式(不使用同步锁) 懒汉模式
 * @author Administrator
 *
 */
public class Singleton {

	private static Singleton sin = new Singleton(); //直接初始化一个实例对象
	//private 类型的构造函数,保证其他类对象不能直接new 一个该对象的控制
	private Singleton(){  
		
	}
	/**
	 * 该类唯一的一个public 方法，获取实例
	 * @return
	 */
	public static Singleton getSin(){ 
		return sin;
	}
}
