package com.self.thread;

import java.util.concurrent.Callable;

public class MyExecutorTest {
	class MyFuture<V>{
		public V get() throws Exception {
			return null;
		}
	}
	static class ExecuteThread<V> extends Thread{
		private V result = null;
		private Exception exception = null;
		private boolean done = false;
		private Callable<V> task;
		private Object lock;
		public ExecuteThread(Callable<V> task,Object lock){
			this.task = task;
			this.lock = lock;
		}
		
		@Override
		public void run() {
			try {
				result = task.call();
			} catch (Exception e) {
				exception = e;
			} finally{
				synchronized (lock) {
					done =true;
					lock.notifyAll();
				}
			}
		}
		public V getResult(){
			return result;
		}
		public boolean isDone(){
			return done;
		}
		public Exception getException(){
			return exception;
		}
		
	}
	public <V> MyFuture<V> execute(final Callable<V> task){
		final Object lock = new Object();
		final ExecuteThread<V> thread = new ExecuteThread<>(task, lock);
		thread.start();
		MyFuture<V> future = new MyFuture<V>(){
			@Override
			public V get() throws Exception{
				synchronized (lock) {
					while(!thread.done){
						try {
							lock.wait();
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					if(thread.getException() !=null){
						throw thread.getException();
					}
					return thread.getResult();
				}
			}
		};
		return future;
	}

	public static void main(String[] args) {
		
	}

}
