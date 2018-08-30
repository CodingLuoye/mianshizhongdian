package com.self.thread.group;

/**
 * 自动归属就是自动归到当前线程组中
 * @author Administrator
 *
 */
public class AutoAddGroup {
	public static void main(String[] args) {
		//方法activeGroupCount()取得当前线程组对象中的子线程组数量
		//方法enumerate(threadGroup[])的作用是将线程组中的子线程组已复制的形式，拷贝到ThreadGroup[]数组对象中
		System.out.println("A处线程：" +Thread.currentThread().getName() + "所属线程组名为： " + Thread.currentThread().getThreadGroup().getName() 
				+ " 中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());
		@SuppressWarnings("unused")
		ThreadGroup group = new ThreadGroup("新的组");
		System.out.println("B处线程：" +Thread.currentThread().getName() + "所属线程组名为： " + Thread.currentThread().getThreadGroup().getName() 
				+ " 中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		ThreadGroup[] threadGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadGroup);
		for (int i = 0; i < threadGroup.length; i++) {
			System.out.println("第一个线程组名称为" + threadGroup[i].getName());
		}
		
	}
}
