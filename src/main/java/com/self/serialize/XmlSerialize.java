package com.self.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
/**
 * xml序列化
 * @author Administrator
 *
 */
public class XmlSerialize {
	public static void main(String[] args) throws Exception {
		Student student = new Student("张三", 18, 80.9d);
		ObjectMapper mapper = new XmlMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String str = mapper.writeValueAsString(student);
		System.out.println(str);
		
		Student s = mapper.readValue(str, Student.class);
		System.out.println(s.toString());
	}

}
