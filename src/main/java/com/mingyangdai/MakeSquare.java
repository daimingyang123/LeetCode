package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 17/2/21
 */
public class MakeSquare {
	
	public static void main(String[] args) {
		MakeSquare makeSquare = new MakeSquare();
//        int[] nums = {1,1,2,2,2};
//        int[] nums = {3,3,3,3,4};
//        int[] nums = {5,5,5,5,4,4,4,4,3,3,3,3};
		int[] nums = {5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4};
		boolean result = makeSquare.makesquare(nums);
		System.out.println(result);
	}
	
	public boolean makesquare(int[] nums) {
		if (nums.length < 4) return false;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 4 != 0) return false;
		long target = sum / 4;
		return makesquare(nums, 0, target, target, 0);
	}
	
	private boolean makesquare(int[] nums, int index, long cur, long target, int count) {
		if (cur < 0) return false;
		if (cur == 0) {
			count++;
			if (count == 4) {
				return true;
			}
			cur = target;
		}
		int temp;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) continue;
			temp = nums[i];
			nums[i] = 0;
			if (makesquare(nums, index + 1, cur - temp, target, count)) {
				return true;
			}
			nums[i] = temp;
			while (i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
		}
		StringBuilder builder = new StringBuilder();
		for (int i : nums) {
			builder.append(i);
		}
		System.out.println(builder.toString());
		return false;
	}
}
