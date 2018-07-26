package com.self.thread;

/**
 * 协作
 * @author JackChen
 *
 */
class Worker extends Thread{
	MyLach latch;
	public Worker(MyLach latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			Thread.sleep((int)(Math.random()*1000));
			this.latch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class MyLach {

	private int count;
	public MyLach(int count){
		this.count = count;
	}
	public synchronized void await() throws InterruptedException{
		while(count>0){
			wait();
		}
	}
	public synchronized void countDown(){
		count --;
		if(count<=0){
			notifyAll();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		int workerNum = 100;
		MyLach latch = new MyLach(workerNum);
		Worker[] workders = new Worker[workerNum];
		for (int i = 0; i < workerNum; i++) {
			workders[i] = new Worker(latch);
			workders[i].start();
		}
		latch.await();
		System.out.println("collect worker result");
	}
}
