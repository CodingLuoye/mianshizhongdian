package com.self.trade;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trade {
	

	public static void main(String[] args) {
		Map<String ,String> map = new HashMap<>();
//		map.put("glob", "I");
//		map.put("prok", "V");
//		map.put("pish", "X");
//		map.put("tegi", "L");
//		Scanner sc = new Scanner(System.in);
//		String src = sc.nextLine();
		String src = "glob glob Silver is 34 Credits";
		System.out.println(Trade.replaceSymbol(src));
		String srcMap = Trade.replaceSymbol(src);
		String [] array = srcMap.split("is");
		map.put(array[0], array[1]);
		String src1 = "glob prok Gold is 57800 Credits";
		System.out.println(Trade.replaceSymbol(src1));
		String srcMap1 = Trade.replaceSymbol(src1);
		String [] array1 = srcMap1.split("is");
		map.put(array1[0], array1[1]);
		String src2 = "pish pish Iron is 3910 Credits";
		System.out.println(Trade.replaceSymbol(src2));
		String srcMap2 = Trade.replaceSymbol(src2);
		String [] array2 = srcMap2.split("is");
		map.put(array2[0], array2[1]);
	}
	
	public static String replaceSymbol(String symbol){
		String string ="";
		string = symbol.replace("glob", "I");
		string = string.replace("prok", "V");
		string = string.replace("pish", "X");
		string = string.replace("tegi", "L");
		return string;
	}

}
