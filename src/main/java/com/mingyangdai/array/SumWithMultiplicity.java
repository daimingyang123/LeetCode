package com.mingyangdai.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author mingyang.dai
 * @since 2018/10/14
 */
public class SumWithMultiplicity {
	public int threeSumMulti(int[] A, int target) {
		int res = 0;
		Arrays.sort(A);
		
		HashMap<Integer, Integer> countMap = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			int count = countMap.getOrDefault(A[i], 0) + 1;
			countMap.put(A[i], count);
		}
		
		for (int i = 0; i < A.length; i++) {
			int j = i + 1;
			for (; j < A.length; j++) {
				if (!countMap.containsKey(target - A[i] - A[j])) continue;
				if (target - A[i] - A[j] < A[j]) break;
				
				int count = 1;
				int c1 = countMap.get(A[i]);
				count *= c1;
				countMap.put(A[i], c1 - 1);
				int c2 = countMap.get(A[j]);
				count *= c2;
				countMap.put(A[j], c2 - 1);
				int c3 = countMap.get(target - A[i] - A[j]);
				count *= c3;
				
				count %= 1000000007;
				
				if (A[i] == A[j] && A[j] == target - A[i] - A[j]) {
					count /= 6;
				} else if (A[i] == A[j] || A[j] == target - A[i] - A[j] || A[i] == target - A[i] - A[j]) {
					count /= 2;
				}
				res += count;
				
				countMap.put(A[i], c1);
				if (A[i] != A[j]) {
					countMap.put(A[j], c2);
				}
				while (j < A.length - 1 && A[j] == A[j + 1]) j++;
			}
			while (i < A.length - 1 && A[i] == A[i + 1]) i++;
		}
		
		return res % 1000000007;
	}
	
	public static void main(String args[]) {
		int[] A = new int[3000];
		int target = 0;
		int res = new SumWithMultiplicity().threeSumMulti(A, target);
		System.out.println(res);
	}
}
