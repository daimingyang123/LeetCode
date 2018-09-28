package com.mingyangdai.treeset;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author mingyang.dai
 * @since 2018/9/14
 */
public class RemoveKDigits {
	
	public String removeKdigits(String num, int k) {
		if(num.length() == k) {
			return "0";
		}
		
		char[] array = num.toCharArray();
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();//n-indexs
		for (int i = 0; i < k; i++) {
			Integer key = array[i] - '0';
			TreeSet<Integer> set = map.getOrDefault(key, new TreeSet<>());
			set.add(i);
			map.put(key, set);
		}
		
		int start = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = k; i < array.length; i++) {
			Integer key = array[i] - '0';//put new
			TreeSet<Integer> set = map.getOrDefault(key, new TreeSet<>());
			set.add(i);
			map.put(key, set);
			
			Map.Entry<Integer, TreeSet<Integer>> entry = map.firstEntry();//get smallest
			key = entry.getKey();
			builder.append(key);
			
			set = entry.getValue();
			int end = set.pollFirst();//remove first
			if (set.isEmpty()) {
				map.remove(key);
			} else {
				map.put(key, set);
			}
			
			for (int j = start; j < end; j++) {//make invalid
				key = array[j] - '0';
				set = map.get(key);
				set.remove(j);
				if (set.isEmpty()) {
					map.remove(key);
				} else {
					map.put(key, set);
				}
			}
			start = end + 1;
		}
		
		int n = Integer.parseInt(builder.toString());
		return Integer.toString(n);
	}
	
	public static void main(String args[]) {
		String num = "10200";
		int k = 1;
//		String res = new RemoveKDigits().removeKdigits(num, k);
//		System.out.println(res);
		System.out.println(new BigInteger("0200").toString());
	}
}
