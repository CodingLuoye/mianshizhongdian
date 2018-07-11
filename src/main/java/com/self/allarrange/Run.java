package com.self.allarrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Run {
	private static String[] mustHaveStrArr = new String[] { "1", "2", "2", "3", "4", "5" };

	private static boolean isValidNumber(String numberStr) {
		/* str中必须包含1、2、3、4、5；或者说1、2、3、4、5都必须存在于str中 */
		for (String mustHaveStr : mustHaveStrArr) {
			if (numberStr.indexOf(mustHaveStr) < 0) {
				return false;
			}
		}

		/* 必须包含两个2 */ //是必要的，因为经过第一个限制条件，你过滤出来的可能是 123445 123845——仍然非法
		List<String> numberStrList = Arrays.asList(numberStr.split(""));
		int counterOf2 = 0;
		Iterator<String> iterator = new ArrayList<>(numberStrList).iterator();
		while (iterator.hasNext()) {
			if ("2".equals(iterator.next())) {
				counterOf2++;
			}
		}
		if (counterOf2 != 2) {
			return false;
		}

		/* 4不能在第三位 */
		if (numberStr.charAt(2) == '4') {
			return false;
		}
		// 不能出现 35 或 53
		if (numberStr.indexOf("35") >= 0 || numberStr.indexOf("53") >= 0) {
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		/*for (int i = 122345; i < 543221; i++) {
			if (isValidNumber(String.valueOf(i))) {
				System.out.println(i);
			}
		}*/
		int a = 4;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toHexString(a));
		a = a>>2;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toHexString(a));
		a = a <<3;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toHexString(a));
		a = a >>>3;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toHexString(a));
		
		char c = 'A';
		System.out.println(c+32);
		char d = (char) (c +32);
		System.out.println(d);
		
	}

}
