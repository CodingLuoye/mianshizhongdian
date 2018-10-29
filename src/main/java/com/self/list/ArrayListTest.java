package com.self.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数组测试
 * @author Administrator
 *
 */
public class ArrayListTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("12");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.add("10");
		/*list数组初始化为10,当第10个元素被复值时，list是不会增长长度，也不会开辟新的空间，当第11个元素
		 *将会开辟新的空间,新增后的长度为10+10/2 
		 * 
		 */
		System.out.println(list.toString());
		list.add("11");
		System.out.println(list.hashCode());
		
		Map<String,String> map = new HashMap<String,String>();
		for (int i = 0; i < 32; i++) {
			map.put(i+" ", "aaa"+i);
		}
		for (int i = 0; i < 8; i++) {
			map.put("111", "bbb");
		}
		
		map.put("222", "bbb");
	}

}
