package com.self.thread;

//生产者
public class Consumer extends Thread {

	MyBlockingQueue<String> queue;
	public Consumer(MyBlockingQueue<String> queue){
		this.queue = queue;
	}
	@Override
	public void run() {
		try {
			while (true) {
				String task = queue.take();
				System.out.println("produce take  "+ task);
				Thread.sleep((int)(Math.random() *100));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyBlockingQueue<String> queue =new MyBlockingQueue<>(10);
		new Consumer(queue).start();
		new Producer(queue).start();
	}
}
