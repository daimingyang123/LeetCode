package com.mingyangdai.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/5/28
 */
public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		int p = Arrays.binarySearch(arr, x);
		if (p < 0) p = -p - 1;
		
		int l = p - 1, r = p;
		for (int i = 0; i < k; i++) {
			if (l >= 0 && r < arr.length) {
				if (x - arr[l] <= arr[r] - x) {
					res.add(arr[l--]);
				} else {
					res.add(arr[r++]);
				}
			} else if (l >= 0) {
				res.add(arr[l--]);
			} else {
				res.add(arr[r++]);
			}
		}
		
		Collections.sort(res);
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{0,0,1,2,3,3,4,7,7,8};
		List<Integer> res = new FindKClosestElements().findClosestElements(arr, 3, 5);
		System.out.println(res);
	}
}
