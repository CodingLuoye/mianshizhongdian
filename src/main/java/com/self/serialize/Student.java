package com.self.serialize;

/**
 * 用户测试的Student
 * @author JackChen
 * @JsonIgnore 可以使其不序列化,反序列化是默认值
 *
 */
public class Student{
	String name;
	int age;
	double score;
	public Student(){
		
	}
	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
}
