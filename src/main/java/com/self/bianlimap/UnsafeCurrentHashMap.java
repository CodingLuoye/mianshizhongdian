package com.self.bianlimap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
/**
 * hashMap是线程不安全的,在多个线程同时对其进行读写的时候,会造成死循环
 * Hashtable的大小增加到一定的时候，性能会急剧下降，因为迭代时需要被锁定很长的时间。
 * 因为ConcurrentHashMap引入了分割(segmentation)，不论它变得多么大，仅仅需要锁定map的某个部分，而其它的线程不需要等到迭代完成才能访问map。
 * 简而言之，在迭代的过程中，ConcurrentHashMap仅仅锁定map的某个部分，而Hashtable则会锁定整个map
 * 
 * HashTable的线程安全使用的是一个单独的全部Map范围的锁，ConcurrentHashMap抛弃了HashTable的单锁机制，使用了锁分离技术，使得多个修改操作能够并发进行,只有进行SIZE()操作时ConcurrentHashMap会锁住整张表。
 * HashTable的put和get方法都是同步方法,而ConcurrentHashMap的get方法多数情况都不用锁，put方法需要锁。
 * 但是ConcurrentHashMap不能替代HashTable,因为两者的迭代器的一致性不同的，hashTable的迭代器是强一致性的，而concurrentHashmap是弱一致的。
 * ConcurrentHashMap的get,clear,iterator 都是弱一致性的
 * 
 * Hashtable继承于 Dictionary 类，实现了 Map, Cloneable, java.io.Serializable接口。存储的是内容是键值对，通过拉链法实现哈希表。
 * HashTable容器使用synchronized来保证线程安全，但在线程竞争激烈的情况下HashTable的效率非常低下
 * 
 * @author Administrator
 *
 */
public class UnsafeCurrentHashMap {
	public static void main(String[] args) {
		final Map<Integer,Integer> map = new HashMap<>();
//		final Map<Integer,Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(){
				Random rnd = new Random();
				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
						map.put(rnd.nextInt(), 1);
					}
				}
			};
			t.start();
		}
		final Map<Integer,Integer> map2 = new Hashtable<>();
		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(){
				Random rnd = new Random();
				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
						map2.put(rnd.nextInt(), 1);
					}
				}
			};
			t.start();
		}
		
		final Map<Integer,Integer> map3 = new ConcurrentHashMap<>();
		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(){
				Random rnd = new Random();
				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
						map3.put(rnd.nextInt(), 1);
					}
				}
			};
			t.start();
		}
	}
}
