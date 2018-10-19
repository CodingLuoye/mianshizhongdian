package com.self.serialize;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * json序列化
 * @author Administrator
 *
 */
public class JsonSerialize {
	public static void main(String[] args) throws Exception {
		Student student = new Student("张三", 18, 80.9d);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String str = mapper.writeValueAsString(student);
		System.out.println(str);
		
		//反序列化
		Student s = mapper.readValue(str, Student.class);
		System.out.println(s.toString());
		
		
		//list的序列化和反序列
		List<Student> students =  Arrays.asList(new Student[]{
			new Student("张三", 18, 80.9d),new Student("李四", 17, 70.9d)	
		});
		String str2 = mapper.writeValueAsString(students);
		System.out.println(str2);
		
		ObjectMapper mapper2 = new ObjectMapper();
		List<Student> list = mapper2.readValue(str2, new TypeReference<List<Student>>() {
		});
		System.out.println(list.toString());
	}
}
