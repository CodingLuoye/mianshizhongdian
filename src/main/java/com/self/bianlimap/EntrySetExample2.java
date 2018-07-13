package com.self.bianlimap;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.self.bianlimap.Worker.Day;

class Worker{
	enum Day{
		MONDAY,TUESDAY,WEdNESDAY,THRUSDAY,FRIDAY,SATURDAY,SUNDAY
	}
	String name;
	Set<Day> availableDays;
	public Worker(String name,Set<Day> availableDays){
		this.name = name;
		this.availableDays = availableDays;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Day> getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(Set<Day> availableDays) {
		this.availableDays = availableDays;
	}
}
public class EntrySetExample2 {
	
	public static void main(String[] args) {
		Worker[] workers = new Worker[]{
			new Worker("张三",EnumSet.of(Day.MONDAY,Day.TUESDAY,Day.FRIDAY,Day.WEdNESDAY)),
			new Worker("李四",EnumSet.of(Day.TUESDAY,Day.THRUSDAY,Day.SATURDAY)),
			new Worker("王五",EnumSet.of(Day.TUESDAY,Day.THRUSDAY))
		};
		Set<Day> days = EnumSet.allOf(Day.class);
		for (Worker w : workers) {
			days.removeAll(w.getAvailableDays());
		}
		System.out.println(days);
		
		Set<Day> dayss = EnumSet.noneOf(Day.class);
		for (Worker w : workers) {
			dayss.addAll(w.getAvailableDays());
		}
		System.out.println(dayss);
		
		Set<Day> daysss = EnumSet.allOf(Day.class);
		for (Worker w : workers) {
			daysss.retainAll(w.getAvailableDays());
		}
		System.out.println(daysss);
		
		Set<Worker> availableWorkers = new HashSet<Worker>();
		for (Worker w : workers) {
			if(w.getAvailableDays().containsAll(EnumSet.of(Day.MONDAY,Day.TUESDAY))){
				availableWorkers.add(w);
			}
		}
		for(Worker w : availableWorkers){
			System.out.println(w.getName());
		}
		
		//哪些天至少会有两个人来
		Map<Day,Integer> countMap = new EnumMap<>(Day.class);
		for(Worker w:workers){
			for(Day d:w.getAvailableDays()){
				Integer count = countMap.get(d);
				countMap.put(d, count==null?1:count+1);
			}
		}
		Set<Day> day1 = EnumSet.noneOf(Day.class);
		for (Map.Entry<Day, Integer> entry:countMap.entrySet()) {
			if(entry.getValue()>=2){
				day1.add(entry.getKey());
			}
		}
		System.out.println(day1);
	}
}
