package com.mingyangdai.bitmanipulation;

/**
 * @author mingyang.dai
 * @since 2017/9/19
 */
public class ConvertaNumbertoHexadecimal {
	char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	
	public String toHex(int num) {
		if(num == 0) return "0";
		String result = "";
		while(num != 0){
			int index = num & 15;
			result = map[index] + result;
			num = (num >>> 4);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.toHexString(15));
		ConvertaNumbertoHexadecimal hexadecimal = new ConvertaNumbertoHexadecimal();
		int num = 26;
		String res = hexadecimal.toHex(num);
		System.out.println(res);
	}
}
