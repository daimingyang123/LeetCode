package com.mingyangdai;

import java.util.Arrays;

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
		int[] nums = {2,2,3,4};
		int res = triangleNumber(nums);
		System.out.println(res);
	}
}
