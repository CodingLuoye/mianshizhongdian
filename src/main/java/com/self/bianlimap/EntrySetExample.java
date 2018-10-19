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
		/*星期一*/
		MONDAY,
		/*星期二*/
		TUESDAY,
		/*星期三*/
		WEdNESDAY,
		/*星期四*/
		THRUSDAY,
		/*星期五*/
		FRIDAY,
		/*星期六*/
		SATURDAY,
		/*星期日*/
		SUNDAY
	}
	
	public static void main(String[] args) {
		//noneOf返回的set为空
		Set<Day> weekend = EnumSet.noneOf(Day.class);
		weekend.add(Day.SATURDAY);
		weekend.add(Day.SUNDAY);
		System.out.println(weekend);
	}
}
