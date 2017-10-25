package com.mingyangdai.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2017/8/14
 */
public class PermutationinString {
	
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) return false;
		
		Map<Character, Integer> map1 = new HashMap<>();
		for (char c : s1.toCharArray()) {
			Integer count = map1.getOrDefault(c, 0)+1;
			map1.put(c, count);
		}
		
		Map<Character, Integer> map2 = new HashMap<>();
		char[] array = s2.toCharArray();
		for (int i=0; i<s1.length(); i++) {
			char cur = array[i];
			Integer count = map2.getOrDefault(cur, 0)+1;
			map2.put(cur, count);
		}
		
		for (int i=s1.length(); i<array.length; i++) {
			if (map1.equals(map2)) {
				return true;
			} else {
				char pre = array[i-s1.length()];
				Integer count = map2.get(pre)-1;
				if (count == 0) map2.remove(pre);
				else map2.put(pre, count);
				
				char cur = array[i];
				count = map2.getOrDefault(cur, 0)+1;
				map2.put(cur, count);
			}
		}
		
		return map1.equals(map2);
	}
	
	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidboaab";
		PermutationinString permutationinString = new PermutationinString();
		boolean res = permutationinString.checkInclusion(s1, s2);
		System.out.println(res);
	}
}
