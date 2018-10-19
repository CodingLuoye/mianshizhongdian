package com.self.list;

import java.util.Arrays;

/**
 * 并归排序法:
 * ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
 * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
 * ③. 重复步骤②，直到所有元素排序完毕
 * 平均时间复杂度	最好情况	最坏情况	  空间复杂度
 * O(nlogn)	  O(nlogn)	O(nlogn)	O(n)
 * 
 * @author Administrator
 *
 */
public class MergeSort {

	public static int[] sort(int[] a){
		if(a.length <=1){
			return a;
		}
		int num = a.length>>1;
		int[] left = Arrays.copyOfRange(a, 0,num);
		int[] right = Arrays.copyOfRange(a, num, a.length);
		return mergeTwoArray(sort(left),sort(right));
		
	}
	
	public static int[] mergeTwoArray(int[] a,int[] b){
		int i =0,j=0,k=0;
		//申请额外的空间保存并归后的数据
		int[] result = new int[a.length+b.length]; 
		while(i<a.length && j<b.length){
			if(a[i]<b[j]){
				result[k++] = a[i++];
			}else{
				result[k++] = b[j++];
			}
		}
		//序列a中多余的元素移入新数组
		while(i<a.length){ 
			result[k++] = a[i++];
		}
		//序列b中多余的元素移入新数组
		while(j<b.length){ 
			result[k++] = b[j++];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int [] b = {3,1,4,5,2};
		System.out.println(Arrays.toString(sort(b)));

	}

}
