package com.mingyangdai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 17/3/13
 */
public class Greater {
	public static void main(String[] args) {
		Greater greater = new Greater();
//        "foobarfoobar"
//                ["foo","bar"]
		String s = "foobarfoobar";
		String words[] = {"foo", "bar"};
		List<Integer> result = greater.findSubstring(s, words);
		System.out.println(result);
	}
	
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		int temp;
		for (int i = 0; i < findNums.length; i++) {
			temp = findNums[i];
			for (int j = map.get(temp) + 1; j < nums.length; j++) {
				if (nums[j] > temp) {
					findNums[i] = nums[j];
					break;
				}
			}
			if (findNums[i] == temp) findNums[i] = -1;
		}
		
		return findNums;
	}
	
	//    s: "barfoothefoobarman"
//    words: ["foo", "bar"]
//    You should return the indices: [0,9].
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s.length() == 0) return result;
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		Map<Integer, String> indexMap = new HashMap<Integer, String>();
		
		for (String word : words) {
			if (countMap.containsKey(word)) countMap.put(word, countMap.get(word) + 1);
			else countMap.put(word, 1);
		}
		
		for (int i = 0; i <= s.length() - words[0].length(); i++) {
			for (String word : words) {
				if (s.substring(i).startsWith(word)) {
					indexMap.put(i, word);
				}
			}
		}
		
		findSubstring(s, words[0].length(), countMap, indexMap, result);
		return result;
	}
	
	public void findSubstring(String s, int length, Map<String, Integer> countMap, Map<Integer, String> map, List<Integer> result) {
		int end = s.length() - (countMap.size() * length);
		int index;
		HashMap<String, Integer> copy;
		String word;
		
		for (int start = 0; start <= end; start++) {
			index = start;
			copy = new HashMap<String, Integer>(countMap);
			while (index <= (s.length() - length) && copy.containsKey(map.get(index))) {
				word = map.get(index);
				if (copy.get(word) > 1) copy.put(word, copy.get(word) - 1);
				else copy.remove(word);
				index += length;
			}
			if (copy.size() == 0) result.add(start);
		}
	}
}
