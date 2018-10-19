package com.self.bianlimap;

import java.util.LinkedHashMap;

/**
 * LRU(Least recently used，最近最少使用算法)
 * 
 * 
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K,V> extends LinkedHashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxEntries;
	
	/**
	 * 当accessOrder为true时，get方法和put方法都会调用recordAccess方法使得最近使用的Entry移到双向链表的末尾；当accessOrder为默认值false时，从源码中可以看出recordAccess方法什么也不会做
	 * 设置maxEntries 后，如果进来的元素个数超过了maxEntries的值，则会清理最开始进来的元素
	 * @param maxEntries
	 */
	public LRUCache(int maxEntries){
		super(16,0.75f,true);
		this.maxEntries = maxEntries;
	}
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size()>maxEntries;
	}
	
	public static void main(String[] args) {
		LRUCache<String,Object>  cache = new LRUCache<>(3);
		cache.put("a", "abstract");
		cache.put("b", "base");
		cache.put("c", "cell");
		System.out.println(cache.toString());
		cache.get("a");
		System.out.println(cache.toString());
		cache.put("d", "default");
		System.out.println(cache.toString());
		//{c=cell, a=abstract, d=default}
	}
}
