package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/7/7
 */
public class ZigZag {
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int num = 4;
		
		ZigZag zigZag = new ZigZag();
		String result = zigZag.convert(s, num);
		System.out.println(result);
	}
	
	public String convert2(String s, int numRows) {
		if (numRows < 2) return s;
		
		StringBuilder builder = new StringBuilder();
		int index = 0;
		
		while (index < s.length()) {
			int start = index;
			while (start < s.length()) {
				builder.append(s.charAt(start));
				int first = numRows - start % (numRows + 1);
				int second = numRows - 2;
				start += first + second;
			}
			index++;
		}
		
		return builder.toString();
	}
	
	public String convert(String s, int nRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
		
		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
				sb[idx].append(c[i++]);
			for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
				sb[idx].append(c[i++]);
		}
		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);
		return sb[0].toString();
	}
}
