package com.mingyangdai.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mingyang.dai
 * @since 2017/8/14
 */
public class PermutationinString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) return false;
		
		Set<Character> set = new HashSet<>();
		for (char c : s2.toCharArray()) {
			set.add(c);
		}
		for (char c : s1.toCharArray()) {
			if (!set.contains(c)) return false;
		}
		
		char[] array = s1.toCharArray();
		Arrays.sort(array);
		boolean[] visited = new boolean[array.length];
		Set<String> strings = new HashSet<>();
		permutation(array, visited, new StringBuilder(), strings);
		for (String s : strings) {
			if (s2.contains(s)) return true;
		}
		return false;
	}
	
	private void permutation(char[] array, boolean[] visited, StringBuilder cur, Set<String> set) {
		if (cur.length() == array.length) {
			set.add(cur.toString());
			return;
		}
		
		for (int i=0; i<array.length; i++) {
			if (visited[i]) continue;
			if (i>0 && array[i] == array[i-1] && !visited[i-1]) continue;
			
			visited[i] = true;
			cur.append(array[i]);
			permutation(array, visited, cur, set);
			visited[i] = false;
			cur.deleteCharAt(cur.length()-1);
		}
	}
	
	public static void main(String[] args) {
		String s1 = "abcc";
		String s2 = "eidbaooo";
		PermutationinString permutationinString = new PermutationinString();
		boolean res = permutationinString.checkInclusion(s1, s2);
		System.out.println(res);
	}
}
