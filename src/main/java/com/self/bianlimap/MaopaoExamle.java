package com.self.bianlimap;

import java.util.Arrays;

/**
 * 冒泡算法
 * @author YCKJ1409
 *
 */
public class MaopaoExamle {

    public static void main(String[] args) {

        int[] num = new int []{7,5,3,1,2,4,6};
        for(int i =0;i<num.length;i++){
            for(int j =1;j<num.length;j++){
               if(num[j-1] < num[j]){
                   int temp = num[j-1];
                   num[j-1] = num[j];
                   num[j] = temp;
               }
            }
            Arrays.stream(num).forEach((a)->System.out.print(a));
            System.out.println();
        }
        Arrays.stream(num).forEach((a)->System.out.print(a));

    }

}
