package com.self.reflect.aspect;

/**
 *
 * @author YCKJ1409
 */
public class CGLibContainerDemo {
	public static void main(String[] args) {
		ServiceA a = CGLibContainer.getInstance(ServiceA.class);
		a.callB();
	}
}


