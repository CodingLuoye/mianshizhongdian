package com.self.reflect;

public class SimpleStaticProxyDemo {

	static interface IService{
		public void sayHello();
	}
	static class RealService implements IService{
		@Override
		public void sayHello() {
			System.out.println("hello");
		}
	}
	static class TraceProxy implements IService{
		private IService relaService;
		public TraceProxy(IService relaService){
			this.relaService = relaService;
		}
		@Override
		public void sayHello() {
			System.out.println("entring sayHello");
			this.relaService.sayHello();
			System.out.println("leaving sayHello");
		}
	}
	public static void main(String[] args) {
		IService realService = new RealService();
		IService proxyService = new TraceProxy(realService);
		proxyService.sayHello();
	}
}
