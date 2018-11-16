package com.mingyangdai.treemap;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author mingyang.dai
 * @since 2018/10/1
 */
public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
		for (int i = 0; i < temperatures.length; i++) {
			TreeSet<Integer> set = map.getOrDefault(temperatures[i], new TreeSet<>());
			set.add(i);
			map.put(temperatures[i], set);
		}
		
		int[] res = new int[temperatures.length];
		for (int i = 0; i < res.length; i++) {
			Map.Entry<Integer, TreeSet<Integer>> entry = map.higherEntry(temperatures[i]);
			if (entry == null) {
				continue;
			}
			Integer j = entry.getValue().higher(i);
			if (j != null) {
				res[i] = j - i;
			}
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		int[] array = new int[]{73,74,75,71,69,72,76,73};
		int[] res = new DailyTemperatures().dailyTemperatures(array);
		System.out.println(res);
	}
}
