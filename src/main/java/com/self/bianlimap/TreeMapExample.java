package com.self.bianlimap;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Comparable 只有 public int compareTo(T o);然排序的排序方法
 * Comparable 可以自定义两个对象进行比较
 * @author Administrator
 *
 */
public class TreeMapExample {
	
	public static void main(String[] args) {
//		Map<String,String> map = new TreeMap<>();
//		Map<String,String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		/*Map<String,String> map = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});*/
//		Map<String,String> map = new TreeMap<>(Collections.reverseOrder());
		Map<String,String> map = new TreeMap<>(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		map.put("a", "abstract");
		map.put("b", "bell");
		map.put("c", "call");
		map.put("T", "tree");
		for (Entry<String,String> kb:map.entrySet()) {
			System.out.println(kb.getValue());
		}
	}
}
