package com.self.list;

import java.util.LinkedList;
import java.util.List;
/**
 * LinkedList测试
 * @author cl
 *
 */
public class LinkedListTest {
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("1");
		list.add("12");
		list.add("3");
		System.out.println(list.toString());
		System.out.println(list.get(1));
	}
}
