package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2017/9/26
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
//	public static int lengthOfLongestSubstring(String s) {
//		int cur = Integer.MIN_VALUE;
//		int n = s.length(), ans = 0;
//		Map<Character, Integer> map = new HashMap<>(); // current index of character
//		// try to extend the range [i, j]
//		for (int j = 0, i = 0; j < n; j++) {
//			if (map.containsKey(s.charAt(j))) {
//				//1.
//				i = Math.max(map.get(s.charAt(j)), i);
//			}
//			ans = Math.max(ans, j - i + 1);
//			map.put(s.charAt(j), j + 1);
//		}
//		return ans;
//	}
	
	public int lengthOfLongestSubstring(String s) {
		int[] map = new int[26];
		for (int i=0; i<map.length; i++) {
			map[i] = -1;
		}
		
		char[] array = s.toCharArray();
		int start = 0, i = 0, max = 0;
		for (; i<array.length; i++) {
			int index = array[i] - 'a';
			if (map[index] != -1) {
				max = Math.max(max, i-start);
				start = Math.max(start, map[index]+1);
			}
			map[index] = i;
		}
		max = Math.max(max, array.length-1-start);
		return max;
	}
	
	public static void main(String[] args) {
		String s = "zwnigfunjwz";
		int length = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
		System.out.println(length);
	}
}
