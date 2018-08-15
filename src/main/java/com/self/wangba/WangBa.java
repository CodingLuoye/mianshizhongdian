package com.self.wangba;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class WangBa implements Runnable {
	private DelayQueue<Customer> custQueue = new DelayQueue<Customer>();
	public boolean isYingYe = true;//用volatile修饰干嘛？这可是WangBa线程内部用的field，不是公共资源的field

	/**
	 * 增加一个新用户/新用户上机
	 * @param name
	 * @param id
	 * @param money
	 */
	public void addCust(String name, String id, int money) {
		Customer customer = new Customer(name, id, 1000 * money + System.currentTimeMillis());//一个单位的钱 上机一秒
		System.out.println("网名" + customer.getName() + " 身份证" + customer.getId() + "交钱" + money + "块,开始上机...");
		this.custQueue.add(customer);
	}

	/**
	 * 打印用户下机信息
	 * @param customer
	 */
	public void printCustOffInfo(Customer customer) {
		System.out.println("网名" + customer.getName() + " 身份证" + customer.getId() + "时间到下机...");
	}

	@Override
	public void run() {
		while (isYingYe) {
			try {
				Customer customer = custQueue.take();//ele 到期即被取出(取出的顺序按照延迟时间 短 -> 长)
				printCustOffInfo(customer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		try {
			/*网吧开始营业了...*/
			System.out.println("网吧开始营业...");
			WangBa wangBa = new WangBa();
			new Thread(wangBa).start();

			/*zhangsan（身份证号2984372917547）充值上机，充值金额10元 */
			wangBa.addCust("zhangsan", "2984372917547", 10);
			/*lisi（身份证号6754372325417547）充值上机，充值金额1元 */
			wangBa.addCust("lisi", "6754372325417547", 1);
			/*wangwu（身份证号22243729175XXX）充值上机，充值金额6元 */
			wangBa.addCust("wangwu", "22243729175XXX", 6);
			/*zhaoliu（身份证号HH8437265g547）充值上机，充值金额5元 */
			wangBa.addCust("zhaoliu", "HH8437265g547", 5);

			/*顾客们正在玩耍...*/
			TimeUnit.SECONDS.sleep(5);

			/*newguy（身份证号98He8437f5g547）充值上机，充值金额6元 */
			wangBa.addCust("newguy", "98He8437f5g547", 6);
			
			/* 观察控制台，看看下机顺序是否正确（充钱少的先下机） */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}