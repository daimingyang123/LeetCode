package com.mingyangdai.dp;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2018/2/3
 */
public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
		Map<Character, List<String>> map = new HashMap<>();
		for (String word : wordDict) {
			char c = word.toCharArray()[0];
			List<String> words = map.getOrDefault(c, new ArrayList<>());
			words.add(word);
			map.put(c, words);
		}
		
		char[] array = s.toCharArray();
		int i = 0;
		for (; i < array.length; i++) {
			char c = array[i];
			List<String> words = map.getOrDefault(c, new ArrayList<>());
			
			boolean flag = false;
			for (String word : words) {
				int j = i + word.length();
				if (j <= s.length() && s.substring(i, j).equals(word)) {
					flag = true;
					i = j;
					break;
				}
			}
			if (!flag) return false;
		}
		return i == array.length;
	}
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> list = Lists.newArrayList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		
		s = "leetcode";
		list = Lists.newArrayList("leet", "code");
		boolean res = new WordBreak().wordBreak(s, list);
		System.out.println(res);
	}
}
