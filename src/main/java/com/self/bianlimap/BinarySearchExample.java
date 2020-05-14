package com.self.bianlimap;

/**
 * @author YCKJ1409
 * 二分查找
 */
public class BinarySearchExample {

    public static void main(String[] args) {
        int value = 8;
        int[] num = new int[]{10,8,7,5,3,0};
        System.out.println(search(num,value));
    }

    public static int search(int num[],int value){
        int lo =0;int high = num.length-1;int mid;
        while(lo<=high){
            mid = (lo+high)/2;
            if(num[mid]==value){
                return mid + 1;
            }else if(num[mid]>value){
                lo = mid +1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }
}
