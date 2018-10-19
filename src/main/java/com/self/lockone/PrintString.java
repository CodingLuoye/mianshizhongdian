package com.self.lockone;

public class PrintString implements Runnable{

	private boolean isContinuePrint = true;
	public boolean isContinuePrint(){
		return isContinuePrint;
	}
	public void setContinuePrint(boolean isContinuePrint){
		this.isContinuePrint = isContinuePrint;
	}
	public void printStringMethod(){
		try {
			while(isContinuePrint == true){
				System.out.println(" run pritnStringMethod threadName=" + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		printStringMethod();
	}

	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		new Thread(printStringService).start();
		System.out.println("我要停止它！stopThread = " + Thread.currentThread().getName());
		printStringService.setContinuePrint(false);
	}
}
