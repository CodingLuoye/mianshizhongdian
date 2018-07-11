package com.self.binarysearch;

public class Run {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 7, 8, 9 };
		System.out.println(BinarySearch.binarySearch(arr, 9));
		System.out.println(BinarySearch.binarySearch(arr, 8));
		System.out.println(BinarySearch.binarySearch(arr, 7));
		System.out.println(BinarySearch.binarySearch(arr, 5));
		System.out.println(BinarySearch.binarySearch(arr, 3));
		System.out.println(BinarySearch.binarySearch(arr, 1));
		System.out.println(BinarySearch.binarySearch(arr, 0));
		System.out.println(BinarySearch.binarySearch(arr, 2));
		System.out.println(BinarySearch.binarySearch(arr, 11));
		System.out.println(BinarySearch.binarySearch(arr, 88));
	}

}