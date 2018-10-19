package com.self.innerclass;

public class PublicStaticClass {
	static private String username;
	static private String password;
	class PrivateClass{
		private String age;
		private String address;
		public String getAge(){
			return age;
		}
		public void setAge(String age){
			this.age = age;
		}
		public String getAddress(){
			return address;
		}
		public void setAddress(String address){
			this.address = address;
		}
		public void printPublicProperty(){
			System.out.println(username + " " +password);
		}
	}
	public String getUsername() {
		return username;
	}
	@SuppressWarnings("static-access")
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@SuppressWarnings("static-access")
	public void setPassword(String password) {
		this.password = password;
	}
	public static void main(String[] args) {
		PublicStaticClass publicClass = new PublicStaticClass();
		publicClass.setUsername("usernameValue");
		publicClass.setPassword("passwordValue");
		System.out.println(publicClass.getUsername() + " " + publicClass.getPassword());
		PrivateClass privateClass = publicClass.new PrivateClass();
		privateClass.setAge("ageValue");
		privateClass.setAddress("addressValue");
		System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
	}
}
