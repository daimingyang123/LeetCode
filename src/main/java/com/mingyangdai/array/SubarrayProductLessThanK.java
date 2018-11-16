package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/10/19
 */
public class SubarrayProductLessThanK {
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) return 0;
		int prod = 1, ans = 0, left = 0;
		for (int right = 0; right < nums.length; right++) {
			prod *= nums[right];
			while (prod >= k) prod /= nums[left++];
			ans += right - left + 1;
		}
		return ans;
	}
	
	public static void main(String args[]) {
		int[] nums = {10,5,2,5};
		int k = 100;
		int res = new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k);
		System.out.println(res);
	}
}
