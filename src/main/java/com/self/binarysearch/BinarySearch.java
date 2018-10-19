package com.self.binarysearch;

/**
 * 二分查找
 * @author Administrator
 *
 */
public class BinarySearch {

	public static int binarySearch(int[] arr, int dest) {
		if (dest > arr[arr.length - 1] || dest < arr[0]) {
			return -1;
		}
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int middle = (high + low) / 2;
			if (dest == arr[middle]) {
				return middle;
			} else if (dest < arr[middle]) {
				high = middle - 1;//减一加一肯定要有啊，因为middle不是嘛 说明在后半部分未找到元素，把high移动到middle的左边
			} else {
				low = middle + 1; //说明在前半部分未找到元素，所以把low移动到middle的右边
			}
		}

		return -1;
	}

}