package com.self.thread;

class FireFlag{
	private volatile boolean fired = false;
	public synchronized void waitForFire() throws Exception{
		while(!fired){
			wait();
		}
	}
	public synchronized void fire(){
		this.fired = true;
		notifyAll();
	}
}

class Racer extends Thread{
	FireFlag fireFlag;
	public Racer(FireFlag fireFlag){
		this.fireFlag = fireFlag;
	}
	@Override
	public void run() {
		try {
			this.fireFlag.waitForFire();
			System.out.println("start run" + Thread.currentThread().getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
public class Meanwhile {

	public static void main(String[] args) throws InterruptedException {
		int num = 10;
		FireFlag fireFlag = new FireFlag();
		Thread[] racers = new Thread[num];
		for (int i = 0; i < num; i++) {
			racers[i] = new Racer(fireFlag);
			racers[i].start();
		}
		Thread.sleep(1000);
		fireFlag.fire();
	}

}
