package com.self.sort;
/**
 * @author YCKJ1409
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] array = new int[]{1,3,5,4,2};
        for(int i =1;i<array.length;i++) {
            for(int j=0;j<array.length-i;j++) {
                if(array[j]>array[j+1]) {
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        System.out.println(array);

    }
}
