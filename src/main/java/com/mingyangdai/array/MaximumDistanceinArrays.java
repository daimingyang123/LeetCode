package com.mingyangdai.array;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/10/4
 */
public class MaximumDistanceinArrays {
	public int maxDistance(List<List<Integer>> arrays) {
		HashSet<Integer> set = new HashSet<>();
		TreeMap<Integer, Integer> minMap = new TreeMap<>();
		TreeMap<Integer, Integer> maxMap = new TreeMap<>();
		for (int i=0; i<arrays.size(); i++) {
			List<Integer> list = arrays.get(i);
			if (list.size() > 0) {
				minMap.put(list.get(0), i);
				if (minMap.size() > 2) minMap.pollLastEntry();
				maxMap.put(list.get(list.size()-1), i);
				if (maxMap.size() > 2) maxMap.pollFirstEntry();
			}
		}
		
		Map.Entry<Integer, Integer> min = minMap.pollFirstEntry();
		Map.Entry<Integer, Integer> max = maxMap.pollLastEntry();
		if (min.getValue() != max.getValue()) return max.getKey()-min.getKey();
		
		int dis = max.getKey()-minMap.pollLastEntry().getKey();
		dis = Math.max(dis, maxMap.pollFirstEntry().getKey()-min.getKey());
		return dis;
	}
	
	public static void main(String[] args) {
		MaximumDistanceinArrays arrays = new MaximumDistanceinArrays();
		List<List<Integer>> list = new ArrayList<>();
		list.add(Lists.newArrayList(1));
		list.add(Lists.newArrayList(1));
		int dis = arrays.maxDistance(list);
		System.out.println(dis);
	}
}
