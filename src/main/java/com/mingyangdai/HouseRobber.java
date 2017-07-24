package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 17/3/3
 */
public class HouseRobber {
	
	public static void main(String[] args) {
		HouseRobber robber = new HouseRobber();
//        int[] nums = {2,1,3,4,5,7};
//        int result = robber.rob(nums);
//        System.out.println(result);
		int n = 1001;
		System.out.println(n >> 3);
		
	}
	
	public int rob2(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
		
		int[] max = new int[nums.length];
		boolean flag = false;
		max[0] = nums[0];
		
		if (nums[0] >= nums[1]) {
			flag = true;
			max[1] = nums[0];
			max[2] = nums[0] + nums[2];
		} else {
			max[1] = nums[1];
			max[2] = Math.max(nums[1], nums[2]);
		}
		
		for (int i = 3; i < nums.length - 1; i++) {
			max[i] = Math.max(max[i - 3], max[i - 2]) + nums[i];
		}
		
		int index = nums.length - 1;
		if (flag && nums[index] + nums[1] > nums[0]) {
			max[index] = Math.max(max[index - 3], max[index - 2]) - nums[0] + nums[1] + nums[index];
		} else {
			max[index] = Math.max(max[index - 3], max[index - 2]) + nums[index];
		}
		
		return Math.max(max[max.length - 2], max[max.length - 1]);
	}
	
	public int rob(int num[], int n) {
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				a = Math.max(a + num[i], b);
			} else {
				b = Math.max(a, b + num[i]);
			}
		}
		
		return Math.max(a, b);
	}
}
