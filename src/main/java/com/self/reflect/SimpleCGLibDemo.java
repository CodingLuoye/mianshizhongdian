package com.self.reflect;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class SimpleCGLibDemo {

	static class RealService{
		public void sayHello(){
			System.out.println("hello");
		}
	}
	static class SimpleInterceptor implements MethodInterceptor{

		@Override
		public Object intercept(Object object, Method method, Object[] args,
				MethodProxy proxy) throws Throwable {
			System.out.println("entring" + method.getName());
			Object result = proxy.invokeSuper(object, args);
			System.out.println("leaving" + method.getName());
			return result;
		}
	}
	private static<T> T getProxy(Class<T> cls){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(new SimpleInterceptor());
		return (T)enhancer.create();
	}
	public static void main(String[] args) {
		RealService proxyService = getProxy(RealService.class);
		proxyService.sayHello();
	}
}
