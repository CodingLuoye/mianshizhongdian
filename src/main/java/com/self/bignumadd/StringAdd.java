package com.self.bignumadd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 两个超出范围的数相加
 * @author Administrator
 *
 */
public class StringAdd {

	public void processMethod(String str1, String str2) {

		String[] strArr1 = str1.split("");
		List<String> strList1 = Arrays.asList(strArr1);
		Collections.reverse(strList1);
		//		System.out.println(strList1);

		String[] strArr2 = str2.split("");
		List<String> strList2 = Arrays.asList(strArr2);
		Collections.reverse(strList2);
		//		System.out.println(strList2);

		boolean hasJinWei = false;
		List<String> showList = new ArrayList<String>();
		Iterator<String> iterator1 = strList1.iterator();
		Iterator<String> iterator2 = strList2.iterator();
		while (iterator1.hasNext() || iterator2.hasNext()) {
			int num1 = 0;
			int num2 = 0;
			if (iterator1.hasNext()) {
				num1 = Integer.parseInt(iterator1.next());
			}
			if (iterator2.hasNext()) {
				num2 = Integer.parseInt(iterator2.next());
			}

			if (hasJinWei) {//前面有进位
				int wei = 1 + num1 + num2;
				if (wei < 10) {
					showList.add(wei + "");
					hasJinWei = false;
				} else {
					showList.add(wei - 10 + "");
					hasJinWei = true;
				}
			} else {//前面无进位
				int wei = num1 + num2;
				if (wei < 10) {
					showList.add(wei + "");
					hasJinWei = false;
				} else {
					showList.add(wei - 10 + "");
					hasJinWei = true;
				}
			}
		}

		Collections.reverse(showList);
		Iterator<String> showListIterator = showList.iterator();
		while (showListIterator.hasNext()) {
			System.out.print(showListIterator.next());
		}
	}
}
