package com.self.reflect;

/**
 *
 * @author YCKJ1409
 */
public class SimpleMapperDemo {
	static class Student{
		String name;
		int age;
		Double score;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Double getScore() {
			return score;
		}
		public void setScore(Double score) {
			this.score = score;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", score=" + score
					+ "]";
		}
		public Student(){

		}
		public Student(String name, int age, Double score) {
			super();
			this.name = name;
			this.age = age;
			this.score = score;
		}
	}
	public static void main(String[] args) {
		Student zhangsan = new Student("zhangsan",23,89d);
		String str = SimpleMapper.toString(zhangsan);
		System.out.println(str);
		Student stu = (Student) SimpleMapper.fromString(str);
		System.out.println(stu);
	}

}
