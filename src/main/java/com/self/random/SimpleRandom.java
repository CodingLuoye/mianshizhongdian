package com.self.random;

import java.util.Random;

/**
 * 包含特殊字符的随机数
 * @author Administrator
 *
 */
public class SimpleRandom {

	private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/"; 
	
	public static char nextChar(Random rnd){
		switch(rnd.nextInt(4)){
		case 0:
			return (char)('a'+rnd.nextInt(26));
		case 1:
			return (char)('A'+rnd.nextInt(26));
		case 2:
			return (char)('0'+rnd.nextInt(10));
		default:
			return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = new char[8];
		Random rnd = new Random();
		for (int i = 0; i < 8; i++) {
			chars[i] = nextChar(rnd);
		}
		System.out.println(new String(chars));
	}

}
