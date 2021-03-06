package com.self.random;

import java.util.Random;
/**
 *  简单的抢红包算法
 *  优化强红包算法，保证每个人都能抢得到钱，最少一角球
 * @author Administrator
 *
 */
public class RandomRedPacket {

	private int leftMoney;
	private int leftNum;
	private Random rnd;
	public RandomRedPacket(int total,int num){
		this.leftMoney = total;
		this.leftNum = num;
		this.rnd = new Random();
	}
	public synchronized int nextMoney(){
		if(this.leftNum<=0){
			throw new IllegalStateException("抢光了");
		}
		if(this.leftNum==1){
			return this.leftMoney;
		}
		double max = this.leftMoney/this.leftNum*2d;
		int money=(int)(rnd.nextDouble()* max);
		money = money<1?1:money;
		if(this.leftMoney - money >0){
			this.leftMoney -= money;
		}else{
			money = money -1;
			this.leftMoney -= money;
		}
		this.leftNum --;
		return money;
	}
	
	public static void main(String[] args) {
		RandomRedPacket redPacket = new RandomRedPacket(10, 5);
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(){
				@Override
				public void run(){
					System.out.println("线程:"+Thread.currentThread().getName()+"抢到了"+redPacket.nextMoney()+"角钱");
				}
			};
			thread.start();
		}
	}
}
