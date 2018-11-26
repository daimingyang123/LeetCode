package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/10/8
 */
public class FindPivotIndex {
	public int pivotIndex(int[] nums) {
		if (nums.length < 3) return -1;
		
		int s = 0, e = nums.length - 1;
		int l = 0, r = 0;
		
		while (s < e) {
			if (nums[s] == 0) {
				s++;
				continue;
			}
			if (nums[e] == 0) {
				e--;
				continue;
			}
			
			if ((l < r && nums[s] > 0) || (l < r && nums[e] > 0) || (l > r && nums[s] < 0) || (l > r && nums[e] < 0)) {
				l += nums[s++];
			} else {
				r += nums[e--];
			}
		}
		
		if (l == r) {
			return s;
		} else {
			return -1;
		}
	}
	
	public static void main(String args[]) {
		int res = new FindPivotIndex().pivotIndex(new int[]{-1,-1,0,1,1,1});
		System.out.println(res);
	}
}
