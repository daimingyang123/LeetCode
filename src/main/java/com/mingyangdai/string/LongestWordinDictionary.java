package com.mingyangdai.string;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/4/7
 */
public class LongestWordinDictionary {
	
	public String longestWord(String[] words) {
		TreeMap map = new TreeMap();
		
		Arrays.sort(words, Comparator.comparingInt(o->o.length()));
		List<String> res= new ArrayList<>();
		String pre = words[0];
		for (int i = 1; i < words.length; i++) {
			String cur = words[i];
			if (cur.length() == pre.length() + 1 && cur.startsWith(pre)) continue;
			
			if (cur.length() == 1) {
				pre = cur;
			} else {
				return null;
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
	}
	
}
