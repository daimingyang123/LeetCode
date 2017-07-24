package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 17/2/18
 */
public class RestoreIpAddresses {
	
	public static void main(String[] args) {
		RestoreIpAddresses addresses = new RestoreIpAddresses();
//        String s = "25525511135";
//        String s = "0000";
//        String s = "010010";
//        System.out.println(addresses.restoreIpAddresses(s));
//        boolean result = addresses.isValid("100");
//        System.out.println(result);
		int i = 1;
		long j = i / 4;
		System.out.println(Integer.MIN_VALUE);
	}
	
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		restore(s, 0, new String(""), result);
		return result;
	}
	
	private void restore(String s, int count, String cur, List<String> result) {
		if (count == 3) {
			if (isValid(s)) {
				result.add(cur + "." + s);
			}
			return;
		}
		String subString;
		String newCur;
		for (int i = 1; i <= 3; i++) {
			if (s.length() < i + 1) return;
			subString = s.substring(0, i);
			if (isValid(subString)) {
				newCur = count == 0 ? subString : cur + "." + subString;
				restore(s.substring(i), count + 1, newCur, result);
			}
		}
	}
	
	private boolean isValid(String s) {
		if (s.length() == 0) return false;
		if (s.length() > 1 && s.charAt(0) == '0') return false;
		long value = Long.parseLong(s);
		return value >= 0 && value <= 255;
	}
}
