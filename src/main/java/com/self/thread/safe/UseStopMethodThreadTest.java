package com.self.thread.safe;

public class UseStopMethodThreadTest extends Thread {

	private int i = 0;
	@Override
	public void run() {
		try {
			while(true){
				i++;
				System.out.println("i="+i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		UseStopMethodThreadTest thread = new UseStopMethodThreadTest();
		thread.start();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.stop();
	}
}
