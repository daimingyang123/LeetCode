package com.mingyangdai.string;

import java.util.HashMap;

/**
 * @author mingyang.dai
 * @since 2017/9/26
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		char[] array = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0, max = 0;
		
		for(int i=0; i<array.length; i++){
			char cur = array[i];
			if (map.containsKey(cur)) {
				max = Math.max(max, i-start);
				start = Math.max(map.get(cur)+1, start);
			}
			map.put(cur, i);
		}
		max = Math.max(max, array.length-start);
		return max;
	}
	
	public static void main(String[] args) {
		String s = "c";
		LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
		int length = characters.lengthOfLongestSubstring(s);
		System.out.println(length);
	}
}
