package com.self.trade;
public class RomanUtils {
	public static String romanNumberValidator = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
	/**
	 * 判断输入的symbols是否符合规则
	 * @param symbols
	 * @return
	 */
	public static boolean SymbolsRule(String symbols){
		
		return symbols.matches(romanNumberValidator);
	}
	
	/**
	 * 根据symbols获取对应的值
	 * @param symbols
	 * @return
	 */
	public int getSymbolsValue(String symbols){
		int sum = 0;
		int previousNumber = 0;
		if(RomanUtils.SymbolsRule(symbols)){
			for (int i = symbols.length()-1; i>=0; i--) {
				char ch = symbols.charAt(i);
				sum = getValue(RomanNumerals.getValueBySymbol(ch), previousNumber, sum);
				previousNumber = RomanNumerals.getValueBySymbol(ch);
			}
		}else{
			System.out.println("please check you symbols!!!");
		}
		return sum;
	}
	
	/**
	 * 
	 * @param symbolValue 当前symbol对应的value
	 * @param previousNumber 前一个symbol对应的value
	 * @param sum value之和
	 * @return
	 */
	public int getValue(int symbolValue,int previousNumber,int sum){
		if(previousNumber>symbolValue){
			sum = sum - symbolValue;
		}else{
			sum = sum + symbolValue;
		}
		return sum;
	}
	public static void main(String[] args) {
		String symbols = "MCMXLIV";
		RomanUtils romanUtils = new RomanUtils();
		System.out.println(romanUtils.getSymbolsValue(symbols));
		String symbols2 = "MMVI";
		System.out.println(romanUtils.getSymbolsValue(symbols2));
	}
	
		
}
