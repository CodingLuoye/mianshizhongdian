package com.self.perfectnumber;

/**
 * 完数
 * @author YCKJ1409
 */
public class PerfectNumber {

	public static void main(String[] args) {
		for (int i = 2; i <= 1000; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum = sum + j;
				}
			}
			if (i == sum) {
				System.out.println(i);
			}
		}
	}
}
