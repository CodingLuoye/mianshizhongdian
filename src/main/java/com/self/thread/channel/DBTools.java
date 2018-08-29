package com.self.thread.channel;
class BackupA extends Thread{
	private DBTools dbtools;
	
	public BackupA(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}
	@Override
	public void run() {
		dbtools.backupA();
	}
}
class BackupB extends Thread{
	private DBTools dbtools;
	
	public BackupB(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}
	@Override
	public void run() {
		dbtools.backupB();
	}
}
public class DBTools {
	volatile private boolean prevIsA = false;
	synchronized public void backupA(){
		try {
			while(prevIsA == true){
				wait();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println("★ ★ ★ ★ ★");
			}
			prevIsA = true;
			notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public void backupB(){
		try {
			while(prevIsA == false){
				wait();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println("☆ ☆ ☆ ☆ ☆");
			}
			prevIsA = false;
			notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBTools dbtools = new DBTools();
		for (int i = 0; i < 20; i++) {
			BackupB output = new BackupB(dbtools);
			output.start();
			BackupA input = new BackupA(dbtools);
			input.start();
		}
	}
}
