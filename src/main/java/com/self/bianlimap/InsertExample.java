package com.self.bianlimap;

import java.util.Arrays;

/**
 *
 * @author YCKJ1409
 */
public class InsertExample {
    public static void main(String[] args) {
        int[] arr = new int[]{20,11,8,22,21};
        for(int i =1; i<arr.length;i++)
        {
            //插入的数
            int insertVal = arr[i];
            //被插入的位置(准备和前一个数比较)
            int index = i-1;
            //如果插入的数比被插入的数小
            while(index>=0&&insertVal<arr[index])
            {
                //将把 arr[index] 向后移动
                arr[index+1]=arr[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arr[index+1]=insertVal;
        }
        Arrays.stream(arr).forEach((a)->System.out.println(a));
    }

}
