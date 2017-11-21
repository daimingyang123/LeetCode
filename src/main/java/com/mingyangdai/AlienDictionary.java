package com.mingyangdai;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/6/28
 */
public class AlienDictionary {
	
	public static void main(String[] args) {
		String[] words = {
				"wrt",
				"wrf",
				"er",
				"ett",
//				"rfrt",
				"rftt"
		};
		
		for (int i = 0; i < words.length; i++) {
			i++;
			System.out.println(i);
		}
		AlienDictionary dictionary = new AlienDictionary();
		String result = dictionary.alienOrder(words);
		System.out.println(result);
	}
	
	public String alienOrder(String[] words) {
		
		Map<Character, HashSet<Character>> map = new HashMap<>();
		Map<Character, Integer> degree = new HashMap<>();
		
		for (String word : words) {
			for (char c : word.toCharArray()) {
				map.put(c, new HashSet<>());
				degree.put(c, 0);
			}
		}
		
		for (int i = 0; i < words.length - 1; i++) {
			String first = words[i];
			String second = words[i + 1];
			int length = Math.min(first.length(), second.length());
			
			for (int j = 0; j < length; j++) {
				char f = first.charAt(j);
				char s = second.charAt(j);
				
				if (f != s) {
					HashSet<Character> set = map.get(f);
					if (!set.contains(s)) {
						set.add(s);
						map.put(f, set);
						
						Integer d = degree.get(s);
						degree.put(s, d + 1);
					}
					break;
				}
			}
		}
		
		Queue<Character> queue = new LinkedList<>();
		for (Map.Entry<Character, Integer> entry : degree.entrySet()) {
			if (entry.getValue() == 0) queue.add(entry.getKey());
		}
		
		String result = "";
		while (!queue.isEmpty()) {
			char key = queue.poll();
			result += key;
			
			for (char c : map.get(key)) {
				if (degree.containsKey(c)) {
					Integer d = degree.get(c) - 1;
					degree.put(c, degree.get(c) - 1);
					if (d == 0) queue.add(c);
				}
			}
		}
		
		if (result.length() != degree.size()) return "";
		return result;
	}
}
