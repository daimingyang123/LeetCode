package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2017/8/9
 */
public class DecodeWays {
	private int count;
	
	public int numDecodings(String s) {
		count = 0;
		numDecodings(s, 0);
		return count;
	}
	
	private void numDecodings(String s, int start) {
		if (start == s.length()) {
			count++;
			return;
		}
		for (int i=1; i<3 && start+i<=s.length(); i++) {
			String substring = s.substring(start, start+i);
			int num = Integer.parseInt(substring);
			if(num<27) numDecodings(s, start+i);
		}
	}
	
	public static void main(String[] args) {
		String s = "12";
		DecodeWays ways = new DecodeWays();
		int res = ways.numDecodings(s);
		System.out.println(res);
	}
}
