package com.self.binarysearch;

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
				high = middle - 1;//减一加一肯定要有啊，因为middle不是嘛
			} else {
				low = middle + 1;
			}
		}

		return -1;
	}

}