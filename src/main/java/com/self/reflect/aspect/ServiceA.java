package com.self.reflect.aspect;
/**
 * ServiceA
 * @author YCKJ1409
 */
public class ServiceA {
	@SimpleInject
	ServiceB b;
	
	public void callB(){
		b.action();
	}

	public ServiceB getB() {
		return b;
	}
}
