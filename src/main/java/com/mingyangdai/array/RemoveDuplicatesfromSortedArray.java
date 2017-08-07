package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/8/4
 */
public class RemoveDuplicatesfromSortedArray {
	
	public int removeDuplicates(int[] nums) {
		int index = 0, count = 0;
		while (index < nums.length) {
			int pre = nums[index];
			if (++index == nums.length) return ++count;
			
			if (nums[index] == pre) {
				int start = index;
				int end = start;
				while (end<nums.length && nums[end]==pre) {
					end++;
				}
				if (end == nums.length) return ++count;
				
				for (int i=start; i<end; i++) {
					nums[i] = nums[end];
				}
			}
			count++;
		}
		return count;
	}
	
	public int removeDuplicates(int A[], int n) {
		if(n < 2) return n;
		int id = 1;
		for(int i = 1; i < n; ++i)
			if (A[i] != A[i-1]) {
				A[id] = A[i];
				id++;
			}
		return id;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,3,3,3};
		RemoveDuplicatesfromSortedArray array = new RemoveDuplicatesfromSortedArray();
		int res = array.removeDuplicates(nums, nums.length);
		ArrayUtil.traversal(nums);
		System.out.println(res);
	}
}
