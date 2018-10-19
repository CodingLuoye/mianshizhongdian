package com.self.graph;

import java.util.Arrays;

/**
 * JAVA数组实现顺序表
 * @author Administrator
 *
 */
public class SequenceList<T> {
	
	private final int DEFAULT_SIZE = 16;	//final实例变量显示指定的初始值，且不再变化
	
	private Object[] elementData;	//该数组来保存顺序表的元素
	
	private int capacity;	//保存数组的长度
	
	private int size;	//保存顺序表中当前元素的个数
	
	//以默认的大小创建顺序表
	public SequenceList(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	
	//以指定的大小创建顺序表
	public void SqquenceList(int initSize){
		capacity = 1;
		while(capacity<initSize){
			capacity <<=1;
			elementData  = new Object[capacity];
		}
	}
	
	//获取顺序表中当前元素的个数
	public int length(){
		return size;
	}
	
	//获取顺序表中索引为i处的元素，i表示索引，即以0开始
	@SuppressWarnings("unchecked")
	public T get(int i){
		if(i<0 || i > size -1){
			throw new IndexOutOfBoundsException("顺序表索引越界");
		}
		return (T)elementData[i];
	}
	
	//查看顺序表中指定的元素的索引，若未找到，返回-1
	public int locate(T element){
		for (int i = 0; i < size; i++) {
			if(elementData[i].equals(element)){
				return i;
			}
		}
		return -1;
	}
	
	//在顺序表的指定索引处插入一个元素
	public void insert(T element,int index){
		if(index<0 || index > size){
			throw new IndexOutOfBoundsException("顺序表索引越界");
		}
		ensureCapacity(size+1);//确保顺序表满时进行扩容，从而能插入元素
		//将指定索引后的所有元素向后移动一个位置
		for (int i = size; i >index; i--) {
			elementData[i] = elementData[i-1];
		}
		elementData[index] = element;
		size++;
	}
	
	private void ensureCapacity(int minCapacity){
		//当数组容量已满时，对数组进行扩容。将容量扩展到大于minCapacity的最小2的次方
		if(minCapacity > capacity){
			while(capacity < minCapacity){
				capacity <<= 1;
				elementData = Arrays.copyOf(elementData, capacity);
			}
		}
	}
	
	//在顺序表的末尾添加一个元素
	public void add(T element){
		insert(element,size);
	}
	
	//删除顺序表中指定索引处的元素
	@SuppressWarnings("unchecked")
	public T delete(int index){
		if(index<0 || index > size){
			throw new IndexOutOfBoundsException("顺序表索引越界");
		}
		T oldValue = (T)elementData[index];
		int numMoved = size -index -1;
		if(numMoved>0){
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		elementData[--size] = null;
		return oldValue;
	}
	
	//删除顺序表中的最后一个元素
	public T removie(){
		return delete(size-1);
	}
	
	//判断顺序表是否为空表
	public boolean empty(){
		return size==0;
	}
	
	//清空顺序表
	public void clear(){
		Arrays.fill(elementData, null); //将数组element的每个元素置为null
		size = 0;
	}
	
	@Override
	public String toString(){
		if(size ==0){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0; i < size; i++) {
				sb.append(elementData[i].toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	public static void main(String[] args) {
		SequenceList<Integer> list = new SequenceList<>();
		list.SqquenceList(18);
	}
}
