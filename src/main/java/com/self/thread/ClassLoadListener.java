package com.self.thread;

class A {
	static {
		System.out.println("this is static a ");
	}
	{
		System.out.println("this is a ");
	}
	public A(){
		System.out.println("this is a constructor");
	}
	public void show(){
		System.out.println("this is a method");
	}
}
class B extends A{
	static {
		System.out.println("this is static b ");
	}
	{
		System.out.println("this is b ");
	}
	public B(){
		System.out.println("this is b constructor");
	}
	public void show(){
		System.out.println("this is B method");
	}
}
public class ClassLoadListener {

	public static void main(String[] args) {
		new B().show();  //先执行a的静态代码块，然后执行b的静态代码块，然后执行a的代码块,执行a的构造器，执行b的代码块，执行b的构造器
		/*this is static a 
		this is static b 
		this is a 
		this is a constructor
		this is b 
		this is b constructor
		this is B method */
		
		new B().show();//注意,静态代码块只会执行一次,代码块每次在构造器前面执行一次
	}

}
