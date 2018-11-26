package com.mingyangdai;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		int sum = Arrays.stream(nums).sum();
		if (sum % k != 0) return false;
		
		int i = 0, j = nums.length - 1;
		int target = sum/k;
		int cur = 0, count = 0;
		
		while (i <= j) {
			if (cur < target) {
				cur += nums[j--];
			} else if (cur > target) {
				cur -= nums[++j];
				cur += nums[i++];
			}
			if (cur == target) {
				count++;
				cur = 0;
			}
		}
		return count == k;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,3,5,2,1};
		int k = 4;
		boolean res = new AppTest().canPartitionKSubsets(nums, k);
		System.out.println(res);
	}
}
