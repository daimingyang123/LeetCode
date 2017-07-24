package com.mingyangdai;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/7/8
 */
public class PalindromePairs {
//	Given words = ["abcd", "dcba", "lls", "s", "sssll"]
//	Return [[0, 1], [1, 0], [3, 2], [2, 4]]
//	The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
	
	public static void main(String[] args) {
		String[] words = {"abcd", "dcba", "lls", "s", "sssll", "a", ""};
		PalindromePairs pairs = new PalindromePairs();
		List<List<Integer>> res = pairs.palindromePairs(words);
		System.out.println(res);
	}
	
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (words.length < 2) return res;
		
		HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String word = entry.getKey();
			for (int i = 0; i <= word.length(); i++) {
				String fst = new StringBuilder(word.substring(0, i)).reverse().toString();
				String snd = new StringBuilder(word.substring(i, word.length())).reverse().toString();
				if (isPalindrome(fst) && map.containsKey(snd)) {
					if (!map.get(snd).equals(entry.getValue())) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(snd));
						list.add(entry.getValue());
						res.add(list);
					}
				}
				if (isPalindrome(snd) && map.containsKey(fst)) {
					if (!map.get(fst).equals(entry.getValue())) {
						if (snd.isEmpty()) {
							continue;
						}
						List<Integer> list = new ArrayList<Integer>();
						list.add(entry.getValue());
						list.add(map.get(fst));
						res.add(list);
					}
				}
			}
		}
		
		return res;
	}
	
	private boolean isPalindrome(String word) {
		char[] array = word.toCharArray();
		int start = 0, end = word.length() - 1;
		while (start < end) {
			if (array[start++] != array[end--]) return false;
		}
		return true;
	}
}
