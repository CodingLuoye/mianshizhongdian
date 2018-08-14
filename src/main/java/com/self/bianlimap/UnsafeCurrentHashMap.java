package com.self.bianlimap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * hashMap是线程不安全的,在多个线程同时对其进行读写的时候,会造成死循环
 * @author Administrator
 *
 */
public class UnsafeCurrentHashMap {
	public static void main(String[] args) {
		final Map<Integer,Integer> map = new HashMap<>();
//		final Map<Integer,Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(){
				Random rnd = new Random();
				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
						map.put(rnd.nextInt(), 1);
					}
				}
			};
			t.start();
		}
	}
}
