package com.mingyangdai.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/8/14
 */
public class PermutationinString {
	public boolean checkInclusion(String s1, String s2) {
		List<String> res = new ArrayList<>();
		permutation(s1.toCharArray(), 0, new StringBuilder(), res);
		for (String s : res) {
			if (s2.contains(s)) return true;
		}
		return false;
	}
	
	private void permutation(char[] array, int index, StringBuilder cur, List<String> res) {
		if (cur.length() == array.length) {
			res.add(cur.toString());
			return;
		}
		for (int i=0; i<array.length; i++) {
//			while (i+1<array.length && array[i+1] == array[i]) i++;
			cur.append(array[i]);
			permutation(array, i, cur, res);
			cur.deleteCharAt(cur.length()-1);
		}
	}
	
	public static void main(String[] args) {
		String s1 = "abo";
		String s2 = "eidbaooo";
		PermutationinString permutationinString = new PermutationinString();
		boolean res = permutationinString.checkInclusion(s1, s2);
		System.out.println(res);
	}
}
