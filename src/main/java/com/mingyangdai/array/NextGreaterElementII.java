package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/6/1
 */
public class NextGreaterElementII {
	
	public int[] nextGreaterElements(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = -1;
			for (int j = i + 1; j != i; j++) {
				j = j % nums.length;
				if (nums[j] > nums[i]) {
					res[i] = nums[j];
					break;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{5,4,3,2,1};
		int[] res = new NextGreaterElementII().nextGreaterElements(nums);
		System.out.println(res);
	}
}
