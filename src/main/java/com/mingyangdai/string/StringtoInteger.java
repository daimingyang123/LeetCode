package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2017/8/3
 */
public class StringtoInteger {
	
	public int myAtoi(String str) {
		char[] array = str.trim().toCharArray();
		int start = 0;
		boolean flag = true;
		
		while (start < array.length) {
			if (array[start] == '+') {
				start++;
				break;
			}
			if (array[start] == '-') {
				start++;
				flag = false;
				break;
			}
			if (array[start]-'0' > 0 || array[start]-'0' < 9) {
				break;
			}
			start++;
		}
		
		String numStr = getNumStr(start, array);
		if (numStr.isEmpty()) return 0;
		
		return getInt(numStr, flag);
	}
	
	private String getNumStr(int start, char[] array) {
		StringBuilder numStr = new StringBuilder();
		for (int i=start; i< array.length; i++) {
			int val = array[i]-'0';
			if (val < 0 || val > 9) break;
			numStr.append(val);
		}
		return numStr.toString();
	}
	
	private int getInt(String numStr, boolean flag) {
		char[] array = numStr.toCharArray();
		long res = 0;
		long pow = 1;
		for (int i=array.length-1; i>=0; i--) {
			int val = array[i]-'0';
			val = flag ? val : -val;
			res += val*pow;
			if (res < -2147483648) return -2147483648;
			if (res > 2147483647) return 2147483647;
			pow *= 10;
		}
		return (int) res;
	}
	
	public static void main(String[] args) {
		String[] testCases = {" 181", "+181", "-181", "181+", "", "+ ", "2147483648", "-2147483649"};
//		for (String s : testCases) {
		String s = "-2147483649";
			StringtoInteger stringtoInteger = new StringtoInteger();
			int res = stringtoInteger.myAtoi(s);
			System.out.println(res);
//		}
	}
}
