package com.mingyangdai.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2018/4/15
 */
public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> set = new HashSet<>();
		for (String word : banned) {
			set.add(word);
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : paragraph.split(" ")) {
			word.toLowerCase();
			char last = word.charAt(word.length() - 1);
			if (last < 'a' || last > 'z') word = word.substring(0, word.length() - 1);
			if (set.contains(word)) continue;
			
			int count = map.getOrDefault(word, 0) + 1;
			map.put(word, count);
		}
		
		String res = null;
		int max = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			if (count > max) {
				max = count;
				res = entry.getKey();
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = new String[]{"hit"};
		String res = new MostCommonWord().mostCommonWord(paragraph, banned);
		System.out.println(res);
	}
}
