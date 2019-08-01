package com.self.reflect.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * 异常注解
 * @author YCKJ1409
 */
@Aspect({ServiceB.class})
public class ExceptionAspect {
	public static void exception(Object object,
			Method method, Object[] args, Throwable e) {
		System.err.println("exception when calling: " + method.getName() 
		+ "," + Arrays.toString(args));
	}
}
