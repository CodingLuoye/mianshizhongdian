package com.self.bianlimap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Run {

	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (int i = 1; i <= 10; i++) {
			hashMap.put("" + i, "str" + i);
		}

		/*使用entrySet*/
		for (Entry<String, String> entry : hashMap.entrySet()) {
			System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
		}
		
		/*keySet values*/
		for(String key:hashMap.keySet()){
			System.out.println(key);
		}
		for (String value : hashMap.values()) {
			System.out.println(value);
		}
		
		/*keySet get(key)*/
		for (String key : hashMap.keySet()) {
			System.out.println(key+":"+hashMap.get(key));
		}
		
		Iterator<HashMap.Entry<String, String>> it= hashMap.entrySet().iterator();
		while(it.hasNext()){
			HashMap.Entry<String, String> entry = it.next();
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
	
	}

}
