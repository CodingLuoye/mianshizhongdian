package com.self.bianlimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * 使用PriorityQueue优先队列来实现最小值，默认构造的是最小堆，如果需要修改
 * new PriorityQueue<>(k,new new Comparator<E>() {
			@Override
			public int compare(E o1, E o2) {
				return 0;
			}
		});修改里面的compartor即可
 * @author Administrator
 *
 * @param <E>
 */
public class TopK<E> {

	private PriorityQueue<E> p;
	private int k;
	public TopK(int k){
		this.k = k;
		this.p = new PriorityQueue<>(k);
	}
	public void addAll(Collection<? extends E> c){
		for (E e : c) {
			add(e);
		}
	}
	public void add(E e){
		/*确保有足够的容量*/
		if(p.size()<k){
			p.add(e);
			return ;
		}
		@SuppressWarnings("unchecked")
		Comparable<? super E> head = (Comparable<? super E>)p.peek();
		if(head.compareTo(e)>0){
			//小于TopK中的最小值,不用变
			return;
		}
		//新元素替换原来的最小值成为TopK之一
		//poll 方法每次从 PriorityQueue 的头部删除一个节点，也就是从小顶堆的堆顶删除一个节点
		p.poll();
		p.add(e);
	}
	public <T> T[] toArray(T[] a){
		return p.toArray(a);
	}
	public E getKth(){
		//查看根节点的元素，不改变原来的队列
		return p.peek();
	}
	public static void main(String[] args) {
		
		TopK<Integer> top5 = new TopK<>(5);
		top5.addAll(Arrays.asList(new Integer[]{
				100,1,2,5,6,7,34,9,3,4,5,8,23,21,90,1,0
		}));
		System.out.println(Arrays.toString(top5.toArray(new Integer[0])));
		System.out.println(top5.getKth());
	}
}
