package com.self.allarrange;

abstract class AbstractDevice{
	private String name;
	public abstract double getPrice();
	public AbstractDevice(){}
	public AbstractDevice(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
/**
 * 匿名内部类
 * @author Administrator
 *
 */
public class AnonymousInner {
	public void test(AbstractDevice b){
		System.out.println("购买一个"+b.getName()+"花了"+b.getPrice());
	}
	public static void main(String[] args) {
		AnonymousInner ai = new AnonymousInner();
		ai.test(new AbstractDevice("设备a"){
			@Override
			public double getPrice() {
				return 10;
			}
			
		});
		AbstractDevice d = new AbstractDevice(){
			{
				System.out.println("匿名内部类的初始化模块");
			}
			@Override
			public double getPrice() {
				// TODO Auto-generated method stub
				return 56.2;
			}
			@Override
			public String getName(){
				return "键盘";
			}
			
		};
		ai.test(d);
	}

}
