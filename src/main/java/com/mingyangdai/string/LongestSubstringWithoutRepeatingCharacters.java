package com.mingyangdai.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2017/9/26
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public static int lengthOfLongestSubstring(String s) {
		int cur = Integer.MIN_VALUE;
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				//1.
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "abba";
		int length = lengthOfLongestSubstring(s);
		System.out.println(length);
	}
}
