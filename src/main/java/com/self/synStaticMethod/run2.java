package com.self.synStaticMethod;

public class run2 {
	public static void main(String[] args) {
		Service service = new Service();
		Thread1 a = new Thread1(service);
		a.setName("A");
		a.start();
		Thread2 b = new Thread2(service);
		b.setName("B");
		b.start();
		Thread3 c = new Thread3(service);
		c.setName("C");
		c.start();
		
	}
}
