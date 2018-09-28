package com.mingyangdai.treeset;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author mingyang.dai
 * @since 2018/8/5
 */
public class BoatstoSavePeople {
	
	public int numRescueBoats(int[] people, int limit) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int p : people) {
			int count = map.getOrDefault(p, 0) + 1;
			map.put(p, count);
		}
		
		int res = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int count = entry.getValue();
			for (int i = 0; i < count; i++) {
				Map.Entry<Integer, Integer> target = map.floorEntry(limit - key);
				if (target == null || target.getValue() == 0) continue;
				int targetKey = target.getKey();
				if (targetKey == key && target.getValue() < 2) continue;
				
				map.put(key, entry.getValue() - 1);
				map.put(targetKey, map.get(targetKey) - 1);
				res++;
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			res += entry.getValue();
		}
		return res;
	}
	
	public static void main(String args[]) {
		int[] people = new int[]{44,10,29,12,49,41,23,5,17,26};
		int limit  = 50;
		int res = new BoatstoSavePeople().numRescueBoats(people, limit);
		System.out.println(res);
	}
}
