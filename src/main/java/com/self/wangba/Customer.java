package com.self.wangba;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 客户 实体类
 * @author EricYu
 *
 */
public class Customer implements Delayed {
	/**
	 * 顾客名称
	 */
	private String name;
	/**
	 * 顾客身份证号
	 */
	private String id;
	/**
	 * 顾客上机截止的时间点
	 */
	private long endTime;

//	private TimeUnit timeUnit = TimeUnit.SECONDS;

	public Customer(String name, String id, long endTime) {
		this.name = name;
		this.id = id;
		this.endTime = endTime;
	}

	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}

	/** 
	 * 返回 未过期时长
	 */
	public long getDelay(TimeUnit unit) {
		return endTime - System.currentTimeMillis();// 截止时间 - 当前时间 = 未过期时长
	}

	/** 
	 * 相互比较排序用 
	 */
	public int compareTo(Delayed customer) {
		return (int) (this.getDelay(null) - customer.getDelay(null));
	}

}