package com.self.thread;

public class ThreadLocalInit {
	static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 100;
		};
	};

	public static void main(String[] args) {
		System.out.println(local.get());
		local.set(200);
		local.remove();
		System.out.println(local.get());
		//调用get方法,如果之前没有设置过,会调用该方法获取初始值,默认实现是null,remove
		//删掉当前线程对应的值,再次get,会调用initialValue获取初始值
	}
}
