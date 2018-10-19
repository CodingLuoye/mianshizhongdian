package com.self.bianlimap;

import java.util.EnumSet;
import java.util.Set;

/**
 * EntrySet 简单用法
 * @author Administrator
 *
 */
public class EntrySetExample {

	enum Day{
		MONDAY,TUESDAY,WEdNESDAY,THRUSDAY,FRIDAY,SATURDAY,SUNDAY
	}
	
	public static void main(String[] args) {
		//noneOf返回的set为空
		Set<Day> weekend = EnumSet.noneOf(Day.class);
		weekend.add(Day.SATURDAY);
		weekend.add(Day.SUNDAY);
		System.out.println(weekend);
	}
}
