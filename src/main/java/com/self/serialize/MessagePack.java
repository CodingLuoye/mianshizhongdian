package com.self.serialize;

import java.io.File;

import org.msgpack.jackson.dataformat.MessagePackFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MessagePack {
	public static void main(String[] args) throws Exception {
		Student student = new Student("张三", 18, 80.9d);
		ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
		byte[] bytes = mapper.writeValueAsBytes(student);
		System.out.println(bytes);
		mapper.writeValue(new File("student.json"), student);
	}

}
