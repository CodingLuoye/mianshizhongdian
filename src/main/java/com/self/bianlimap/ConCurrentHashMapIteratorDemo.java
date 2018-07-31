package com.self.bianlimap;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConCurrentHashMapIteratorDemo {

	public static void test(){
		final ConcurrentHashMap<String, String> map = 
				new ConcurrentHashMap<>();
		map.put("a", "abstract");
		map.put("b", "basic");
		Thread t1 = new Thread(){
			@Override
			public void run() {
				for(Entry<String,String> entry:map.entrySet()){
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println(entry.getKey() + "," + entry.getValue());
				}
			};
		};
		t1.start();
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		map.put("g", "call");
	}
	public static void main(String[] args) {
		test();
	}
}
