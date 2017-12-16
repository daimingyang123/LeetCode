package com.mingyangdai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		List<Integer> cur = new ArrayList<>();
		cur.add(1);
		cur.add(2);
		cur.add(3);
		System.out.println(new ArrayList<>(cur).size());
	}
}
