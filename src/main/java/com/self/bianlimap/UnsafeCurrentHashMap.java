package com.self.bianlimap;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class UnsafeCurrentHashMap {
	public static void main(String[] args) {
		final Map<Integer,Integer> map = new ConcurrentHashMap<>();
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
