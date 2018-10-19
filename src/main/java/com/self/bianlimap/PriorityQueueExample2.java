package com.self.bianlimap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 自定义Comparator传入PriorityQueue优先队列，保证Task能够按照一定的任务执行
 * @author Administrator
 *
 */
class Task{
	int priority;
	String name;
	public Task(int priority,String name){
		this.priority = priority;
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
public class PriorityQueueExample2 {
	
	private static Comparator<Task> taskCommparator = new Comparator<Task>() {
		
		@Override
		public int compare(Task o1, Task o2) {
			if(o1.getPriority()>o2.getPriority()){
				return -1;
			}else if(o1.getPriority()<o2.getPriority()){
				return 1;
			}
			return 0;
		}
	};
	
	public static void main(String[] args) {
		Queue<Task> tasks = new PriorityQueue<Task> (11,taskCommparator);
		tasks.offer(new Task(20,"写日记"));
		tasks.offer(new Task(10,"看电视"));
		tasks.offer(new Task(100,"写代码"));
		Task task = tasks.poll();
		while(task!=null){
			System.out.println("处理任务"+task.getName() +", 优先级:"+task.getPriority());
			task = tasks.poll();
		}
	}
	
}
