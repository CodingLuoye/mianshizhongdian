package com.self.thread;

import java.util.Random;

public class AccountMgr {

	@SuppressWarnings("serial")
	public static class NoEnoughMoneyException extends Exception{};
	public static void transer(Account from,Account to,double money) throws NoEnoughMoneyException{
		from.lock();
		try {
			to.lock();
			try {
				if(from.getMoney() >= money){
					from.reduce(money);
					to.add(money);
				}else{
					throw new NoEnoughMoneyException();
				}
			} finally {
				// TODO: handle finally clause
				to.unlock();
			}
		} finally {
			// TODO: handle finally clause
			from.unlock();
		}
	}
	
	public static void main(String[] args) {
		final int accountNum = 10;
		final Account[] accounts = new Account[accountNum];
		final Random rnd = new Random();
		for (int i = 0; i < accountNum; i++) {
			accounts[i] = new Account(rnd.nextInt(10000));
		}
		int threadNum = 100;
		Thread[] threads = new Thread[threadNum];
		for (int i = 0; i < threadNum; i++) {
			threads[i] = new Thread(){
				@Override
				public void run(){
					int loopNum = 100;
					for (int j = 0; j < loopNum; j++) {
						int m = rnd.nextInt(accountNum);
						int n = rnd.nextInt(accountNum);
						int money = rnd.nextInt(10);
						if(m != n){
							try {
								transer(accounts[m], accounts[n], money);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
					}
				}
			};
			threads[i].start();
		}
	}
		
}
