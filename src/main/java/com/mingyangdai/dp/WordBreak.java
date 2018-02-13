package com.mingyangdai.dp;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingyang.dai
 * @since 2018/2/3
 */
public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
		return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
	}
	
	public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
		if (start == s.length()) {
			return true;
		}
		if (memo[start] != null) {
			return memo[start];
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
				return memo[start] = true;
			}
		}
		return memo[start] = false;
	}
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> list = Lists.newArrayList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		boolean res = new WordBreak().wordBreak(s, list);
		System.out.println(res);
	}
}
