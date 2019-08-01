package com.self.trade;

import java.util.Scanner;


public enum RomanNumerals {

	I(1),V(5),X(10),L(50),C(100),D(500),M(1000);
	private int value;
	RomanNumerals(int value){
		this.value = value;
	}
	public int getValue(){
		return this.value;
	}
	
	/**
	 * 根据symbol获取对应的value,如果不存在返回0
	 * @param symbol
	 * @return
	 */
	public static int getValueBySymbol(char symbol){
		int value = 0;
		switch(symbol){
			case 'I' :
				value = RomanNumerals.I.getValue();
				break;
			case 'V' :
				value = RomanNumerals.V.getValue();
				break;
			case 'X' :
				value = RomanNumerals.X.getValue();
				break;
			case 'L' :
				value = RomanNumerals.L.getValue();
				break;
			case 'C' :
				value = RomanNumerals.C.getValue();
				break;
			case 'D' :
				value = RomanNumerals.D.getValue();
				break;
			case 'M' :
				value = RomanNumerals.M.getValue();
				break;
				default:
					value = 0;
		}
		return value;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String src = sc.next().toUpperCase();
		for (char c : src.toCharArray()) {
			System.out.println(RomanNumerals.getValueBySymbol(c));
		}
	}
}
