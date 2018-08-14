package com.self.random;

import java.util.Random;
/**
 * 生成一定规则的随机数,复杂密码
 * @author Administrator
 *
 */
public class ComplexRandom {
	
	private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/"; 
	
	private static int nextIndex(char[] chars,Random rnd){
		int index = rnd.nextInt(chars.length);
		while(chars[index]!=0){
			index = rnd.nextInt(chars.length);
		}
		return index;
	}
	private static char nextSpecialChar(Random rnd){
		return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
	}
	private static char nextUpperlLetter(Random rnd){
		return (char)('A'+rnd.nextInt(26));
	}
	private static char nextLowerLetter(Random rnd){
		return (char)('a'+rnd.nextInt(26));
	}
	private static char nextNumberLetter(Random rnd){
		return (char)('0'+rnd.nextInt(10));
	}
	
	public static String randomPassword(){
		char[] chars = new char[8];
		Random rnd = new Random();
		chars[nextIndex(chars, rnd)] = nextSpecialChar(rnd);
		chars[nextIndex(chars, rnd)] = nextUpperlLetter(rnd);
		chars[nextIndex(chars, rnd)] = nextLowerLetter(rnd);
		chars[nextIndex(chars, rnd)] = nextNumberLetter(rnd);
		for (int i = 0; i < 8; i++) {
			if(chars[i]==0){
				chars[i] = SimpleRandom.nextChar(rnd);
			}
		}
		return new String(chars);
	}
	public static void main(String[] args) {
		System.out.println(ComplexRandom.randomPassword());
	}
}
