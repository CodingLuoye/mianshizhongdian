package com.self.bianlimap;

import java.util.LinkedHashMap;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxEntries;
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
		cache.get("a");
		cache.put("d", "default");
		System.out.println(cache.toString());
		//{c=cell, a=abstract, d=default}
	}
}
