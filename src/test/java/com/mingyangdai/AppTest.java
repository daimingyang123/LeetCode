package com.mingyangdai;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		int i = 0;
		int j = 1;
		int k = 2;
		int pre = k;
		while (i < j) {
			int local = 0;
			while (j < k) {
				while (k < nums.length) {
					if (nums[i] + nums[j] > nums[k]) {
						local++;
						pre = k;
					} else {
						res += local;
						k = pre+1;
						local -= 1;
						break;
					}
					k++;
				}
				j++;
			}
			i++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("c");
		System.out.println(set1.toString());
		LinkedHashSet<String> set2 = new LinkedHashSet<>();
		set2.add("b");
		set2.add("a");
		boolean res = set1.containsAll(set2);
		System.out.println(res);
	}
}
