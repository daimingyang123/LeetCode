package com.mingyangdai.treeset;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author mingyang.dai
 * @since 2018/7/15
 */
public class AdvantageShuffle {
	public int[] advantageCount(int[] A, int[] B) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int n : A) {
			int count = map.getOrDefault(n, 0) + 1;
			map.put(n, count);
		}
		for (int i = 0; i < B.length; i++) {
			Map.Entry<Integer, Integer> entry = map.higherEntry(B[i]);
			if (entry == null) entry = map.firstEntry();
			int key = entry.getKey();
			int count = entry.getValue();
			A[i] = key;
			if (count == 1) map.remove(key);
			else map.put(key, count - 1);
		}
		return A;
	}
	
	public static void main(String args[]) {
		int[] A = {2,0,4,1,2};
		int[] B = {1,3,0,0,2};
		int[] res =new AdvantageShuffle().advantageCount(A, B);
		System.out.println(res);
	}
}
