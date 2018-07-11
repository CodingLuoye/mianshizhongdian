package com.self.allarrange;

abstract class Device{
	private String name;
	public abstract double getPrice();
	public Device(){}
	public Device(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

public class AnonymousInner {
	public void test(Device b){
		System.out.println("购买一个"+b.getName()+"花了"+b.getPrice());
	}
	public static void main(String[] args) {
		AnonymousInner ai = new AnonymousInner();
		ai.test(new Device("设备a"){
			@Override
			public double getPrice() {
				return 10;
			}
			
		});
		Device d = new Device(){
			{
				System.out.println("匿名内部类的初始化模块");
			}
			public double getPrice() {
				// TODO Auto-generated method stub
				return 56.2;
			}
			public String getName(){
				return "键盘";
			}
			
		};
		ai.test(d);
	}

}
