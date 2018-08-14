package com.self.bianlimap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 堆的本质是一个完全二叉树,堆里面的元素都是有顺序的，如果需要改变,传递一个Comparator
 * @author JackChen
 *
 */

public class PriorityQueueExample {
	
	public static void main(String[] args) {
//		Queue<Integer> pq = new PriorityQueue<>();
		Queue<Integer> pq = new PriorityQueue<>(11,Collections.reverseOrder());
		pq.offer(10);
		pq.add(20);
		pq.addAll(Arrays.asList(new Integer[]{
				11,12,34,2,7,4,15,12,8,6,19,13
		}));
		while(pq.peek()!=null){
			System.out.print(pq.poll()+" ");
		}
	}
}
