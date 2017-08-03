package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/8/3
 */
public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length-1;
		while (start <= end) {
			int mid = (start+end) >>> 1;
			if (nums[mid] == target) {
				return mid;
			} else {
				if (start == mid) start++;
				else if (end == mid) end--;
				
				if (nums[mid] > nums[start]) {
					if (target >= nums[start] && target < nums[mid]) {
						end = mid-1;
					} else {
						start = mid+1;
					}
				} else {
					if (target > nums[mid] && target <= nums[end]) {
						start = mid+1;
					} else {
						end = mid-1;
					}
				}
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,1};
		int[] targets = {1};
		SearchinRotatedSortedArray array = new SearchinRotatedSortedArray();
		for (int target : targets) {
			int res = array.search(nums, target);
			System.out.println(res);
		}
	}
}
