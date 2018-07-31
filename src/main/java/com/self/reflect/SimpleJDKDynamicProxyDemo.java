package com.self.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleJDKDynamicProxyDemo {
	static interface IService{
		public void sayHello();
	}
	static class RealService implements IService{
		@Override
		public void sayHello() {
			System.out.println("hello");
		}
	}
	static class SimpleInvocationHandler implements InvocationHandler{
		private Object realObj;
		public SimpleInvocationHandler(Object realObj){
			this.realObj = realObj;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("entring sayHello");
			Object result = method.invoke(realObj, args);
			System.out.println("leving sayHello");
			return result;
		}
	}
	public static void main(String[] args) {
		IService realService = new RealService();
		IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class<?>[]{IService.class}, new SimpleInvocationHandler(realService));
		proxyService.sayHello();
	}
}
