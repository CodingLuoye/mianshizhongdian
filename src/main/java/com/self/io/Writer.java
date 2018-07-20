package com.self.io;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Student{
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
}
public class Writer {
	public static void writeStudent(List<Student> students) throws Exception{
		DataOutputStream output3 = new DataOutputStream(new FileOutputStream("Student.dat"));
		try {
			output3.writeInt(students.size());
			for (Student s : students) {
				output3.writeUTF(s.getName());
				output3.writeInt(s.getAge());
				output3.writeDouble(s.getScore());
			}
		} finally {
			output3.close();
		}
	}
	public static List<Student> readStudents() throws Exception{
		DataInputStream input = new DataInputStream(new FileInputStream("Student.dat"));
		try {
			int size = input.readInt();
			List<Student> students = new ArrayList<Student>(size);
			for (int i = 0; i < size; i++) {
				Student s = new Student();
				s.setName(input.readUTF());
				s.setAge(input.readInt());
				s.setScore(input.readDouble());
				students.add(s);
			}
			return students;
		} finally {
			input.close();
		}
	}
	public static void main(String[] args) throws Exception {
		OutputStream output = new FileOutputStream("hello.txt");
		try {
			String data = "hello, 123 , 老马";
			byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
			output.write(bytes);
		} finally {
			output.close();
		}
		
		InputStream input = new FileInputStream("hello.txt");
		try{
			byte[] buf = new byte[1024];
			int bytesRead = input.read(buf);
			String data = new String(buf,0,bytesRead,"UTF-8");
			System.out.println(data);
		}finally{
			input.close();
		}
		
		InputStream input2 = new FileInputStream("hello");
		try {
			ByteArrayOutputStream output2 = new ByteArrayOutputStream();
			byte[] buf2 = new byte[1024];
			int bytesRead2 = 0;
			while((bytesRead2 = input.read(buf2))!=-1){
				output.write(buf2, 0, bytesRead2);
			}
			String data2 = output2.toString("UTF-8");
			System.out.println(data2);
		} finally {
			input2.close();
		}
		List<Student> students = Arrays.asList(new Student[]{
				new Student("张三",18,80.9d),new Student("李四",17,67.5d)});
		Writer.writeStudent(students);
	}

}
