package com.self.list;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println(list.toString());
		System.out.println(list.get(1));
	}

}
