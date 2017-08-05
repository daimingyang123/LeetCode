package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/8/4
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) return nums.length;
		
		int pre = nums[0], index = 1, count = 1;
		while (index < nums.length) {
			if (nums[index] == pre) {
				int start = index;
				int end = start;
				while (nums[end] == pre) {
					if (end == nums.length-1) return count;
					end++;
				}
				for (index=start; index<nums.length && index<end; index++) {
					nums[index] = nums[end];
				}
				count++;
				pre = nums[start];
				index = end;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,3,3};
		RemoveDuplicatesfromSortedArray array = new RemoveDuplicatesfromSortedArray();
		int res = array.removeDuplicates(nums);
		ArrayUtil.traversal(nums);
		System.out.println(res);
	}
}
