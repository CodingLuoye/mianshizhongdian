package com.self.bianlimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 利用PriorityQueue求中值,将元素放到最大堆和最小堆里面，如果两个堆得数量超过2,则调整中值的位置
 * @author JackChen
 *
 * @param <E>
 */
public class Median<E> {

	private PriorityQueue<E> minP;//最小堆
	private PriorityQueue<E> maxP;//最大堆
	private E m;//当前中值
	public Median(){
		this.minP = new PriorityQueue<>();
		this.maxP = new PriorityQueue<>(11,Collections.reverseOrder());
	}
	@SuppressWarnings("unchecked")
	private int compare(E e,E m){
		Comparable<? super E> cmpr = (Comparable<? super E>)e;
		return cmpr.compareTo(m);
	}
	
	public void add(E e){
		if(m==null){//第一个元素
			m = e;
			return;
		}
		if(compare(e,m)<=0){
			//小于中值,加入最大堆
			maxP.add(e);
		}else{
			minP.add(e);
		}
		if(minP.size() - maxP.size()>=2){
			//最小堆元素个数多，既大于中值的数多
			//将m加到最大堆中,然后将最小堆中的根移除赋值给m
			maxP.add(this.m);
			this.m = minP.poll();
		}else if(maxP.size() - minP.size()>=2){
			minP.add(this.m);
			this.m = maxP.poll();
		}
		
	}
	
	public void addAll(Collection<? extends E> c){
		for (E e : c) {
			add(e);
		}
	}
	
	public E getM(){
		return m;
	}
	
	public static void main(String[] args) {
		Median<Integer> median = new Median<>();
		List<Integer> list = Arrays.asList(new Integer[]{
			34,90,67,45,1,4,5,6,7,9,10	
		});
		median.addAll(list);
		System.out.println(median.getM());
	}
}
